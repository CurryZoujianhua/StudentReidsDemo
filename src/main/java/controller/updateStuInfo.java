package controller;

import Dao.StuDao;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static util.DateUtil.getFormatDate;

@WebServlet(value = "/updateStu.do")
public class updateStuInfo extends HttpServlet {
    StuDao stuDao = new StuDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //根据提交的表单修改学生信息
        //获取参数
        String stuId = request.getParameter("id");
        String name = request.getParameter("stuName");
        String date = request.getParameter("date");
        Date stuBrithday =  getFormatDate(date,"yyyy-MM-dd");
        String description = request.getParameter("description");
        int avgScore =Integer.parseInt( request.getParameter("avgScore"));
        Student student = new Student(stuId,name,stuBrithday,description,avgScore);
        boolean isSuc =  stuDao.updateInfo(student);

        try {
            if (isSuc){
                //修改成功
                request.setAttribute("isSuc", isSuc);
            }else {
                request.setAttribute("isSuc", false);
            }
            getServletContext().getRequestDispatcher("/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }


    }

}
