import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void Reg(String login, String passwordF, String passwordS, boolean haveLogin, Scanner in) throws SQLException {
        ResultSet resultSet;
        while(true){
            System.out.print("login: ");
            login = in.next();
            resultSet = ConnToDB.stat.executeQuery("select * from users");
            while(resultSet.next()){
                if(resultSet.getString(2).equals(login)) {
                    haveLogin = true;
                    break;
                }
            }
            if(haveLogin){
                System.out.print("this login is already using");  System.out.println("");
                haveLogin = false;
            }
            else
                break;
        }
        while(true){
            System.out.print("password: ");
            passwordF = in.next();
            System.out.print("password again: ");
            passwordS = in.next();
            if(passwordS.equals(passwordF)){
                System.out.print("you registered"); System.out.println("");
                haveLogin = false;
                break;
            }
            else{
                System.out.print("password doesnt correct"); System.out.println("");
            }
        }
        ConnToDB.stat.executeUpdate("insert into users (login, password) values ('" + login + "', '" +passwordF +"')");
    }

    public static void Log(String login, String passwordF, String passwordS, boolean haveLogin, Scanner in) throws SQLException {
        ResultSet resultSet;
        while(true) {
            System.out.print("login: ");
            login = in.next();
            System.out.print("password: ");
            passwordF = in.next();
            resultSet = ConnToDB.stat.executeQuery("select * from users");
            while(resultSet.next()){
                if(resultSet.getString(2).equals(login) && resultSet.getString(3).equals(passwordF)){
                    System.out.print("you login"); System.out.println("");
                    haveLogin = true;
                    break;
                }
            }
            if(haveLogin){
                haveLogin = false;
                break;
            }
            else{
                System.out.print("login or pass doesn't correct"); System.out.println("");
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner in = new Scanner(System.in);

        String choice, login = null, passwordF = null, passwordS = null;
        boolean haveLogin = false;

        while(true){
        System.out.print("reg or log: ");
        choice = in.next();
        while (true){
            if(choice.equals("reg")){
                Reg(login, passwordF, passwordS, haveLogin, in);
            }
            else if(choice.equals("log")){
                Log(login, passwordF, passwordS, haveLogin, in);
            }
            else{
                    System.out.print("write correct"); System.out.println("");
                    break;
                }
            }
        }
    }
}

