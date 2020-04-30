<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: zoujianhua
  Date: 2020/4/21
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
    %>
    <title>学生信息</title>

</head>
<body>
<div style="position: absolute;left:20%;margin: 0 auto;right: 50%;width: 70%">
    <a href="/add.jsp">新增</a>
<table border="1" cellspacing="0" width="70%" height="150"    >
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>生日</th>
        <th>备注</th>
        <th>平均分</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${stuList}" var="stu">
        <tr>
            <td>${stu.getId()}</td>
            <td>${stu.getName()}</td>
            <td><fmt:formatDate value="${stu.getBirthday()}" pattern="yyyy/MM/dd" />
            </td>
            <td>${stu.getDescription()}</td>
            <td>${stu.getAvgscore()}</td>
            <td><a href="/GotoUpdate.do?id=${stu.getId()}">修改</a>

                <a href="/delete.do?id=${stu.getId()}">删除</a>
            </td>
        </tr>

    </c:forEach>
</table>
    <div style="width: 70%;height: 50px">
        <span>共10条记录</span>
        <div style="margin-right: 0;">
            <span id="parent"></span>
            <%-- <a href="/getStu.do?curPage=${curPage}&flag=0">上一页</a>--%>
           ${curPage}<a href="/getStu.do?curPage=${curPage}&flag=1">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <span>前往</span>：
            <form action="/getStu.do" style="display: inline-block">
             <input hidden value="2" name="flag">
            <input type="number" name="curPage" style="width:50px;"><button type="submit">Go</button>
            </form>
        </div>
    </div>
</div>

</body>
<script>
    //页面一加载就执行
    var start = 0;
    var end = 9;
    var url = "http://localhost:8080/getStu.do?start="+start+"&end="+end
    window.onload = function () {
        console.log('我执行了');

    }
    //当前页大于1则创建上一页 a标签
     var curPage = "${curPage}";
     if(curPage>1){
         createA();
     }

     //动态创建a标签
    function createA() {
        //获取父子节点
        var parent = document.getElementById("parent");
        var a = document.createElement('a');
        a.setAttribute('href', "/getStu.do?curPage=${curPage}&flag=0");
        a.setAttribute('id', 'startTelMedicine');
        a.innerHTML = "上一页";
        // 防止反复添加
        if(document.getElementById('startTelMedicine')) {
          parent.removeChild(document.getElementById('startTelMedicine'));
        }
       parent.appendChild(a);
    }
</script>
</html>
