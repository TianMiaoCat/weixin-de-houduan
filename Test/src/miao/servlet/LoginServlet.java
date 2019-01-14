package miao.servlet;

import net.sf.json.JSONObject;
import miao.dao.LoginDao;
import miao.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("已经进入LoginSevlet");
        //接收小程序传过来的account和password
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        UserDTO user = new UserDTO(account,password);
        LoginDao logindao = new LoginDao();
        //初始化为false
        Boolean isLogin=false;
        try {
            //判断是否登陆成功
            isLogin = logindao.Login(user);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Map<String,String> map=new HashMap<String,String>();
        if(isLogin) map.put("message", "ok");
        else map.put("message", "err");
        //要将Map转化为JSON，才可以传数据返回小程序
        JSONObject mapObject=JSONObject.fromObject(map);
        System.out.println("mapObject:"+mapObject.toString());
        //从服务器传mapObject数据到小程序
        response.getWriter().write(mapObject.toString());
    }
}
