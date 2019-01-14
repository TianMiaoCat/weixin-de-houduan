package miao.dao;

import miao.dto.UserDTO;
import miao.utils.DataAccess;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {
    Connection con=(Connection) DataAccess.getCon();
    public Boolean Register(UserDTO user) {
        System.out.println("已经进入Register");
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="Insert into user(account,password) values(?,?)";

        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,user.getAccount());
            ps.setString(2,user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
