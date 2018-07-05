package com.isdev.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
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
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        requestLine(req);
//        requestHeaders(req, resp);
        ServletInputStream inputStream = req.getInputStream();
        int len = 0;
        byte[] buf = new byte[1024];
        while((len = inputStream.read())!=-1) {
            String str = new String(buf, 0, len);
            System.out.println(str);
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
