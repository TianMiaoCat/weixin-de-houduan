package miao.utils;

import java.sql.*;

public class DataAccess {
    private static  String driver = "com.mysql.cj.jdbc.Driver";
    private static  String url = "jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";

    private static  String user = "root";
    private static  String pwd = "123456";
    public static Connection getCon() {
        Connection con=null;
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,user,pwd);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }
    public  void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if(rs!=null) {
                rs.close();
                rs=null;
            }
            if(ps!=null) {
                ps.close();
                ps=null;
            }
            if(conn!=null) {
                conn.close();
                conn=null;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
