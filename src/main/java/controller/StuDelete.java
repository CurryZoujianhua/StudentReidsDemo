package controller;

import Dao.StuDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete.do")
public class StuDelete extends HttpServlet {
    StuDao stuDao = new StuDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            //删除信息
            String stuId = request.getParameter("id");
            boolean isSuc = stuDao.deleteInfo(stuId);
            try{
                if (isSuc){
                    getServletContext().getRequestDispatcher("/getStu.do").forward(request, response);
                }
            }catch (Exception e){

            }

    }

}
