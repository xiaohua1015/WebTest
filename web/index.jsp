<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/4
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  GET提交
  <form action="/hello" method="get">
    请输入姓名：<input name="user" type="text" value=""><br/>
    请输入密码：<input name="pass" type="password" value=""><br/>
    性别：<input type="radio" name="sex" value="男">男
    <input type="radio" name="sex" value="女">女<br/>
    爱好：<input type="checkbox" name="hobby" value="篮球">篮球
    <input type="checkbox" name="hobby" value="篮球">足球
    <input type="checkbox" name="hobby" value="篮球">羽毛球<br/>
    描述：<textarea cols="40" rows="10" name="desc"></textarea><br/>
    <input type="submit" value="确定" />
    <input type="submit" value="确定" />
  </form>
  POST提交
  <form action="/hello" method="post">
    请输入姓名：<input name="user" type="text" value=""><br/>
    请输入密码：<input name="pass" type="password" value=""><br/>
    性别：<input type="radio" name="sex" value="男">男
          <input type="radio" name="sex" value="女">女<br/>
    爱好：<input type="checkbox" name="hobby" value="篮球">篮球
          <input type="checkbox" name="hobby" value="篮球">足球
          <input type="checkbox" name="hobby" value="篮球">羽毛球<br/>
    描述：<textarea cols="40" rows="10" name="desc"></textarea><br/>
    <input type="submit" value="确定" />
  </form>
  </body>
</html>
