package controller;


import Dao.JedisPutData;
import entity.Student;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/getStu.do")
public class StuController extends  HttpServlet{
    private  int pageSize = 10;//分页：每一页默认显示10条
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException{
        System.out.println("你好");
        //判断是否分页 flag=0上一页，flag=1下一页
        List<Student> studentList = null;
        String isLimit = request.getParameter("flag");
        if (isLimit==null){
            //没有传分页参数，默认第一页
            studentList =  JedisPutData.getStudentListFromRedis(0,9);
            for (Student stu:studentList ) {
                System.out.println(stu.getName()+" "+stu.getAvgscore());
            }
            request.setAttribute("curPage", 1);
        }else {
            //传递分页，获取分页参数
           //获取当前页
            int curPage = Integer.parseInt(request.getParameter("curPage"));
           // 计算开始下标
            int start = (curPage-1)*pageSize;
            //计算结束下标
            int end = start+9;
            studentList =  JedisPutData.getStudentListFromRedis(start,end);
            if(isLimit.equals("0")){
                request.setAttribute("curPage", curPage-1);
            }if (isLimit.equals("1")){
                //下一页
                request.setAttribute("curPage", curPage+1);
            }if(isLimit.equals("2")){
                //直接前往
                request.setAttribute("curPage", curPage);
            }


        }
        try {
            request.setAttribute("stuList", studentList);
            ServletContext context =  getServletContext();
            context.getRequestDispatcher("/student.jsp").forward(
                    request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
