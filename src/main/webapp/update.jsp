<%@ page import="entity.Student" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="static util.DateUtil.getFormattedString" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zoujianhua
  Date: 2020/4/29
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Student student = (Student) request.getAttribute("student");
    String dateStr = getFormattedString(student.getBirthday(),"yyyy-MM-dd");
    request.setAttribute("dateStr", dateStr);

%>
<html>
<head>
    <title>修改学生页面</title>
</head>
<body>
    <div>
        <form action="/updateStu.do" style="position: absolute;margin: 0 auto;left: 40%;right: 50%;width: 500px;top: 30%;">
            <c:if test="${isSuc}">
                <h3>修改成功</h3>
            </c:if>
            <c:if test="!${isSuc}">
                <h3>修改失败</h3>
            </c:if>
            <input type="text" hidden value="${student.getId()}" name="id">
          <table border="1" cellspacing="0" width="60%" height="150" >
              <tr>
                  <td>姓名</td>
                  <td><input type="text" value="${student.getName()}" name="stuName"/></td>
              </tr>
              <tr>
                  <td>出生日期</td>
                  <td><input type="date" value="${dateStr}" name="date" /></td>
              </tr>
              <tr>
                  <td>备注</td>
                  <td><input type="text" value="${student.getDescription()}" name="description"/></td>
              </tr>
              <tr>
                  <td>平均分</td>
                  <td><input type="number" value="${student.getAvgscore()}" name="avgScore"/></td>
              </tr>
              <tr >
                  <td colspan="2"> <button type="submit" value="提交" >提交</button></td>
              </tr>

          </table>

           <<a href="/getStu.do">返回</a>
        </form>
    </div>
</body>
<script>






</script>
</html>
