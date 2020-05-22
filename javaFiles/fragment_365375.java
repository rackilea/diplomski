/*
 * cancelOrder servlet looks for the cookies associated
 * with the shopping cart confirmation page
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.util.concurrent.TimeUnit;

public class cancelOrder extends HttpServlet {

        //sets initial values for what we will retrieve
        //from the cookie
        String confirmNumber = "0";
        String shippingDate = "01/01/2000";
        Date date;

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    public static long getDateDiffInDays(Date date1, Date date2) {
        long diffInMillis = date2.getTime() - date1.getTime();
        return TimeUnit.MILLISECONDS.toDays(diffInMillis);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        //gets the fields that the user filled
        String enteredConfirmNumber = request.getParameter("ConfirmationNumber");


        //gets cookie value if it matches user input
        Cookie[] cookies = request.getCookies();
        Cookie cookie;
        for(int i=0; i<cookies.length; i++) {
            cookie = cookies[i];
            String foundCookie = cookie.getName();
            //converts cookie name from string
            //to integer 


            if(foundCookie.equals(enteredConfirmNumber)) {
                confirmNumber = foundCookie;
                shippingDate = cookie.getValue();
            }
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 

        try {
            date = formatter.parse(shippingDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //converts shippingDate from string
        //to calendar format
        Calendar shipDate = Calendar.getInstance();
        shipDate.setTime(date);

        //gets today's date in calendar format
        Calendar today = Calendar.getInstance();

        //unsure if this will throw int or string
        long daysTillShip = getDateDiffInDays(today.getTime(), shipDate.getTime());

        if(confirmNumber.equals(enteredConfirmNumber) &&
            daysTillShip > 5) {
                showPage(response, "Your order was successfully canceled.");

        }  else {
            showPage(response, "Either it is less than 5 days before delivery " + 
                                "or your confirmation number does not exist");
        }
    } 

    /**
     * Actually shows the <code>HTML</code> result page
     */
    protected void showPage(HttpServletResponse response, String message)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Status of Your Order</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>" + message + "</h2>");
        out.println("</body>");
        out.println("</html>");
        out.close();

    }

    /** Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    } 

    /** Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }
}