package by.servlets;

import by.DAO.DAOImple;
import by.model.HeroesEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by УВД on 29.05.2017.
 */
public class SaveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOImple daoImple=new DAOImple();
        ////////////////////////////////////////
        //INDEX.JSP
        ////////////////////////////////////////
        if(request.getParameter("add")!=null){//при нажатии на кнопку add
            HeroesEntity heroesEntity=new HeroesEntity();//создаём экземпляр класса модели базы данных
            heroesEntity.setIdhero(Integer.parseInt(request.getParameter("id")));//задаём ему id взятый из поля c именем id
            heroesEntity.setName(request.getParameter("name"));//аналогично с прошлой строкой
            daoImple.saveHero(heroesEntity);//сохраняем в базу данных полученный объект
            request.setAttribute("list",daoImple.getAll());//создаём аттрибут который взял в себя всё что есть в базе данных
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");//перебрасываемся на list.jsp
            requestDispatcher.forward(request,response);
        }
        if(request.getParameter("showAll")!=null){//при нажатии на кнопку showALL
            request.setAttribute("list",daoImple.getAll());//создаём аттрибут который взял в себя всё что есть в базе данных
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");//перебрасываемся на list.jsp
            requestDispatcher.forward(request,response);
        }
        ///////////////////////////////////////////////////
        //LIST.JSP
        ///////////////////////////////////////////////////
        String action=request.getParameter("action");//создаём action который будет реагировать на те или иные действия
        if(action.equalsIgnoreCase("update")){//если action отреагировал на update
          request.setAttribute("hero",daoImple.getHeroById(Integer.parseInt(request.getParameter("idhero"))));//создаём атрибут который по id возвращает определённого HeroesEntity
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("update.jsp");////перебрасываемся на update.jsp
            requestDispatcher.forward(request,response);
        }
        if(action.equalsIgnoreCase("delete")){//если action отреагировал на update
            daoImple.deleteHeroes(Integer.parseInt(request.getParameter("idhero")));//удаляем по id
            request.setAttribute("list",daoImple.getAll());//создаём аттрибут который взял в себя всё что есть в базе данных
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");//перебрасываемся на list.jsp
            requestDispatcher.forward(request,response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOImple daoImple = new DAOImple();
//////////////////////////////////
// UPDATE.JSP
//////////////////////////////////
        if (request.getParameter("update") != null) {//при нажатии на кнопку update
            HeroesEntity heroesEntity = new HeroesEntity();//создаём экземпляр класса
            heroesEntity.setIdhero(Integer.parseInt(request.getParameter("idhero")));//задаём id из поля idhero
            heroesEntity.setName(request.getParameter("name"));//задаём name из поля name
            daoImple.update(heroesEntity);//апдейтим
            request.setAttribute("list", daoImple.getAll());//создаём аттрибут который взял в себя всё что есть в базе данных
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");//перебрасываемся на list.jsp
            requestDispatcher.forward(request, response);
        }
    }
}
