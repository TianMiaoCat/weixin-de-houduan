package miao.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import miao.utils.getOpenid;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        String requestUrl = WX_URL.replace("APPID", "wxcc6e3ac0912b7744").
                replace("SECRET", "cf829271a90dfefaeba02d9b637b20d9").replace("JSCODE", code).
                replace("authorization_code", "authorization_code");
        getOpenid getopenid = new getOpenid();
        String  returnvalue=getopenid.GET(requestUrl);
        JSONObject convertvalue=new JSONObject();
        convertvalue=(JSONObject) JSON.parse(returnvalue);
        String openid=(String) convertvalue.get("openid");
        System.out.println(openid);
    }
}
