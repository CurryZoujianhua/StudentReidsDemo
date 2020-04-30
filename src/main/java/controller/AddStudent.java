package controller;

import Dao.StuDao;
import entity.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static util.DateUtil.getFormatDate;

@WebServlet(value = "/add.do")
public class AddStudent extends HttpServlet {
    StuDao stuDao = new StuDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //新增
        String name = request.getParameter("stuName");
        String date = request.getParameter("date");
        Date stuBrithday =  getFormatDate(date,"yyyy-MM-dd");
        String description = request.getParameter("description");
        int avgScore =Integer.parseInt( request.getParameter("avgScore"));
        Student student = new Student(main.java.util.IDUtil.getGUID(),name,stuBrithday,description,avgScore);
        boolean isSuc = stuDao.addStu(student);
       try {
           if(isSuc){
               request.setAttribute("isSuc", isSuc);
               getServletContext().getRequestDispatcher("/add.jsp").forward(request,response );
           }

       }catch (Exception e){

       }



    }

}
