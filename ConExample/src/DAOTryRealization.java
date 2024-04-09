
import java.sql.*;

public class DAOTryRealization {
    private static final String URL = "jdbc:postgresql://localhost:5432/Animals";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection;

    static{
        try {
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void output(String nameTable){
        try {
            String SQL = String.format("SELECT * FROM %s",nameTable);
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL);
            while(res.next()){
                System.out.print(res.getString("id")+" ");
                System.out.print(res.getString("name")+" ");
                System.out.println(res.getString("contact_information")+" ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void output(String nameTable, int id){
        try {
            String SQL = String.format("SELECT * FROM %s WHERE id = %d", nameTable,id);
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL);
            while(res.next()) {
                System.out.print(res.getInt("id") + " ");
                System.out.print(res.getString("name") + " ");
                System.out.println(res.getString("contact_information") + " ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addInf(String tableName){

        try{
            String insert = String.format("INSERT INTO "+tableName+" (name, contact_information)\n" +
                    "VALUES ('Ice Tea', 375297450342)");
            Statement statement = connection.createStatement();
            statement.executeUpdate(insert);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void upd(String tableName){
        try{
            String upd = String.format("UPDATE "+tableName+" SET name = 'ice T'\n" +
                    "WHERE id = '6'");
            Statement statement = connection.createStatement();
            statement.executeUpdate(upd);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void del(String tableName){
        try{
            String del = String.format("DELETE FROM "+tableName+" WHERE id = '6'");
            Statement statement = connection.createStatement();
            statement.executeUpdate(del);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

}
