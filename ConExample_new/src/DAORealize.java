import java.sql.*;

public abstract class DAORealize {
    private static String URL = "jdbc:postgresql://localhost:5432/Animals";
    private static String USER = "postgres";
    private static String PASSWORD = "password";

    private Connection connection = null;
    {
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

//    public void connectCheck(){
//      2  if(connection != null){
//            System.out.println("подключился");
//        }else System.out.println("не подключился");
//    }

    public abstract void output(String tableName);
    public abstract void output(String tableName, int id);
    public abstract void addInfo(String tableName);
    public abstract void upd(String tableName);
    public abstract void del(String tableName);


    public Statement getStatement(){
        Statement ps = null;
        try {
            ps = connection.createStatement();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return ps;
    }

    public void closeStatement(Statement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
