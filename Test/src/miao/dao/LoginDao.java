package miao.dao;

import miao.dto.UserDTO;
import miao.utils.DataAccess;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    Connection con=(Connection) DataAccess.getCon();
    public Boolean Login(UserDTO user) throws SQLException {
        PreparedStatement ps=null;
        ResultSet rs=null;
        UserDTO AdminiStratordto=new UserDTO();
        String sql="select * from user where account=? and password=?";
        ps=con.prepareStatement(sql);
        ps.setString(1,user.getAccount());
        ps.setString(2,user.getPassword());
        rs=ps.executeQuery();
        if(rs.next())	return true;
        else return false;
    }
}
