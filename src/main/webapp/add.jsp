<%--
  Created by IntelliJ IDEA.
  User: zoujianhua
  Date: 2020/4/29
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增页面</title>
</head>
<body>
<div>
    <form action="/add.do" style="position: absolute;margin: 0 auto;left: 40%;right: 50%;width: 500px;top: 30%;">
        <c:if test="${isSuc}">
            <h3>新增成功</h3>
        </c:if>
        <c:if test="!${isSuc}">
            <h3>新增失败</h3>
        </c:if>
        <table border="1" cellspacing="0" width="60%" height="150" >
            <tr>
                <td>姓名</td>
                <td><input type="text" value="" name="stuName"/></td>
            </tr>
            <tr>
                <td>出生日期</td>
                <td><input type="date" value="" name="date" /></td>
            </tr>
            <tr>
                <td>备注</td>
                <td><input type="text" value="" name="description"/></td>
            </tr>
            <tr>
                <td>平均分</td>
                <td><input type="number" value="" name="avgScore"/></td>
            </tr>
            <tr >
                <td colspan="2"> <button type="submit" value="提交" >提交</button></td>
            </tr>

        </table>

        <<a href="/getStu.do">返回</a>
    </form>
</div>
</body>
</html>
