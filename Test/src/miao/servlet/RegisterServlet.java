package miao.servlet;

import miao.dto.UserDTO;
import miao.dao.RegisterDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("已经进入RegisterServlet");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        System.out.println(account);
        UserDTO user = new UserDTO(account,password);
        RegisterDao registerdao = new RegisterDao();
        Boolean isLogin = registerdao.Register(user);
        if(isLogin) System.out.println("ok");
        else System.out.println("err");
    }
}
