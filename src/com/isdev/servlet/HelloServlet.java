package com.isdev.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by Administrator on 2018/7/4.
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//        String params = req.getQueryString();
//        System.out.println("get params = " + params);
//

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        requestLine(req);
//        requestHeaders(req, resp);
//        requestData(req);
        /**
         * 设值参数的查询码表
         * 该方法支队请求实体内容起作用（即POST请求的参数）
         * get请求可以通过修改：tomcat->conf->server.xml
         * <Connector port="8080" protocol="HTTP/1.1"
         *     connectionTimeout="20000"
         *     redirectPort="8443"
         *     URIEncoding="utf-8"
         />
         * 或者：String name = new String(name.getBytes("iso-8859-1"),"utf-8");
         */
        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=UTF-8");
        Enumeration<String> parameterNames = req.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            if(name.equals("hobby")) {
                System.out.print("爱好：");
                String[] hobbys = req.getParameterValues(name);
                for (String hobby:hobbys) {
                    System.out.print(hobby + ":");
                }
                System.out.println();
            } else {
                System.out.println(name + ":" + req.getParameter(name));
            }
        }
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.println("qwert");
//        resp.getWriter().println("请求成功");

    }

    //请求参数，不知道为啥不能用
    private void requestData(HttpServletRequest req) throws IOException {
        ServletInputStream inputStream = req.getInputStream();
        int len = 0;
        byte[] buf = new byte[1024];
        while((len = inputStream.read())!=-1) {
            String str = new String(buf, 0, len);
            System.out.print(str);
        }
    }

    //获取请求头
    private void requestHeaders(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            System.out.println(name + ":" + req.getHeader(name));
        }

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("这事第一个servlet程序。当前时间为："+ new Date());
    }

    //获取请求行
    private void requestLine(HttpServletRequest req) {
        System.out.println("请求方式：" + req.getMethod());
        System.out.println("请求URI(请求资源)：" + req.getRequestURI());
        System.out.println("请求URL(请求资源)：" + req.getRequestURL());
        System.out.println("请求协议：" + req.getProtocol());
    }
}
