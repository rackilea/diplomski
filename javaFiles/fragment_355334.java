package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.DiagnosisDAO;
import model.Category;
import model.Diagnosis;

/**
 * Servlet implementation class DiagnosisController
 */

@WebServlet(name = "/DiagnosisController", urlPatterns = {
        "/diagnosis",
        "/diagnosis/all"
})

public class DiagnosisController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiagnosisController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        RequestDispatcher dispatcher;


        switch(request.getServletPath()) {
        case "/diagnosis":
            DiagnosisDAO diagDao;
            try(DAOFactory daoFactory = new DAOFactory()){
                diagDao = daoFactory.getDiagnosisDAO();

                Diagnosis diag = diagDao.get_DMFSteam();
                request.setAttribute("DSteam", diag.getDMFSteamList());

            } catch (ClassNotFoundException e1) {
                request.getSession().setAttribute("error", e1.getMessage());
            } catch (SQLException e1) {
                request.getSession().setAttribute("error", e1.getMessage());
            } catch (Exception e1) {
                request.getSession().setAttribute("error", e1.getMessage());
            }
            dispatcher = request.getRequestDispatcher("/view/diagnosis/charts.jsp");
            dispatcher.forward(request, response);
            break;
        }
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub



        doGet(request, response);
    }

}