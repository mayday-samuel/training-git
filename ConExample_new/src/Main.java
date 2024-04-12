import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Dbconnection db = new Dbconnection();
        db.output("owners");
        db.output("owners", 4);
//        db.addInfo("owners");
//        db.del("owners");
//        db.upd("owners");
        

    }
}