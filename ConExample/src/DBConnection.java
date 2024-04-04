import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    public Connection connection(String DBName, String user, String password){
        Connection con = null;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DBName,user,password);
            if(con!=null){
                System.out.println("Подключился к БД");
            }else{
                System.out.println("Не подключился");
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return con;
    }

    public void output(Connection con, String tableName){
        Statement statement;
        ResultSet res = null;
        try {
            String qwery = String.format("SELECT * FROM %s",tableName);
            statement = con.createStatement();
            res = statement.executeQuery(qwery);
            while(res.next()){
                System.out.print(res.getString("id")+" ");
                System.out.print(res.getString("name")+" ");
                System.out.println(res.getString("contact_information")+" ");
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void addInf(Connection con, String tableName){
        Statement statement;
        try{
            String insert = String.format("INSERT INTO "+tableName+" (name, contact_information)\n" +
                    "VALUES ('Ice Tea', 375297450342)");
            statement = con.createStatement();
            statement.executeUpdate(insert);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void upd(Connection con, String tableName){
        Statement statement;
        try{
            String upd = String.format("UPDATE "+tableName+" SET name = 'Water T'\n" +
                    "WHERE id = '6'");
            statement = con.createStatement();
            statement.executeUpdate(upd);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void del(Connection con, String tableName){
        Statement statement;
        try{
            String del = String.format("DELETE FROM "+tableName+" WHERE id = '7'");
            statement = con.createStatement();
            statement.executeUpdate(del);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

}
