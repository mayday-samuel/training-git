import java.sql.*;

public class Dbconnection extends DAORealize {
    @Override
    public void output(String tableName) {

       //connectCheck();

        String sql = String.format("SELECT * FROM %s",tableName);
        Statement ps = getStatement();
        try{
            ResultSet res = ps.executeQuery(sql);
            while(res.next()){
                System.out.print(res.getInt("id") + " ");
                System.out.print(res.getString("name") + " ");
                System.out.println(res.getString("contact_information") + " ");
            }
        }catch(Exception ex){
            System.out.println(ex);
        }finally {
            closeStatement(ps);
        }
    }

    @Override
    public void output(String tableName, int id) {
        String sql = String.format("SELECT * FROM %s WHERE id = %d",tableName,id);
        Statement ps = getStatement();
        try{
            ResultSet res = ps.executeQuery(sql);
            while(res.next()){
                System.out.print(res.getInt("id") + " ");
                System.out.print(res.getString("name") + " ");
                System.out.println(res.getString("contact_information") + " ");
            }
        }catch(Exception ex){
            System.out.println(ex);
        }finally {
            closeStatement(ps);
        }
    }

    @Override
    public void addInfo(String tableName) {
        String sql = String.format("INSERT INTO "+tableName+" (name, contact_information)\n" +
                "VALUES ('Ice Tea', 375297450342)");
        Statement ps = getStatement();
        try{
            ps.executeUpdate(sql);
        }catch(Exception ex){
            System.out.println(ex);
        }finally {
            closeStatement(ps);
        }
    }

    @Override
    public void upd(String tableName) {
        String sql = String.format("UPDATE "+tableName+" SET name = 'ice T'\n" +
                "WHERE id = '8'");
        Statement ps = getStatement();
        try{
            ps.executeUpdate(sql);
        }catch(Exception ex){
            System.out.println(ex);
        }finally {
            closeStatement(ps);
        }
    }

    @Override
    public void del(String tableName) {
        String sql = String.format("DELETE FROM "+tableName+" WHERE id = '6'");
        Statement ps = getStatement();
        try{
            ps.executeUpdate(sql);
        }catch(Exception ex){
            System.out.println(ex);
        }finally {
            closeStatement(ps);
        }
    }


}
