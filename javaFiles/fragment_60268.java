package exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import connectionDB.Constants;

@WebServlet("/AppExceptionHandler")
public class AppExceptionHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processError(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processError(request, response);
    }

    protected void doPut(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processError(request, response);
    }

    protected void doDelete(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processError(request, response);
    }

    protected void doHead(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processError(request, response);
    }

    protected void doOptions(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processError(request, response);
    }

    private void processError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Analyze the servlet exception
        //Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }

        // Set response content type
        response.setContentType("application/xml");

        //Set response content type
        response.setContentType("application/xml");

        PrintWriter out = response.getWriter();
        //<?xml version="1.0" encoding="UTF-8" standalone="yes"?><MW_ERROR_RESPONSE><MW_VERSION>1.0</MW_VERSION><MW_ERRORDESC>Wrong user</MW_ERRORDESC></MW_ERROR_RESPONSE>
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?><MW_ERROR_RESPONSE><MW_VERSION>" + Constants.MW_VERSION +"</MW_VERSION><MW_ERRORDESC>");
        if(statusCode == 405){
            response.setStatus(405);
            out.write("Client Error Request - HTTP method not allowed. Please change your HTTP method in your request</MW_ERRORDESC></MW_ERROR_RESPONSE>");
        }else if(statusCode == 404){
            response.setStatus(404);
            out.write("Client Error Request - Request not found or invalid URI: " + requestUri  + ". Please change your URI request</MW_ERRORDESC></MW_ERROR_RESPONSE>");
        }else{
            response.setStatus(403);
            out.write("Client Error Request - Unknown error</MW_ERRORDESC></MW_ERROR_RESPONSE>");
        }
    }
}