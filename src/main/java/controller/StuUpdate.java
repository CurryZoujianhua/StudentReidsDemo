package controller;

import Dao.StuDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import  entity.Student;

@WebServlet(value = "/GotoUpdate.do")
public class StuUpdate extends HttpServlet {
    StuDao stuDao = new StuDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
                String stuId = request.getParameter("id");
                //根据Id查找对应信息
                System.out.println("学生ID"+stuId);
                Student student= stuDao.getStuById(stuId);
             //将student传递到jsp修改页面
                request.setAttribute("student", student);
        try {
            getServletContext().getRequestDispatcher("/update.jsp")
                               .forward( request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }


    }

}
