import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello and welcome!");
        DBConnection db = new DBConnection();
        Connection con = db.connection("Animals","postgres","D@iDeneg1");
        System.out.println("");

        //db.addInf(con,"owners");
        //db.upd(con,"owners");
        //db.del(con,"owners");
        db.output(con,"owners");
        con.close();
    }
}