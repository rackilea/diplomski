import java.io.IOException;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateLab
 */
@WebServlet("/CreateLab")
public class CreateLab extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateLab() {
        super();
        // TODO Auto-generated constructor stub
    }

     int capacity; 
     String day = ""; 
     String time = ""; 
     String room = ""; 
     int subject_id;
     int user_id;

    public void init() {
      try {
          Class.forName("com.mysql.jdbc.Driver");
          Connection con =
            DriverManager.getConnection("jdbc:mysql://localhost:3306/wae","root","");
        System.out.println("JDBC driver loaded"); 
      } 
      catch (ClassNotFoundException e) {
        System.out.println(e.toString()); 
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 
    } 

    /**Process the HTTP Get request*/ 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws 
  ServletException,IOException {  
      sendPageHeader(response); 
      sendRegistrationForm(request, response, false); 
      sendPageFooter(response); 
    } 

    /**Process the HTTP Post request*/ 
    public void doPost(HttpServletRequest request, 
      HttpServletResponse response) 
      throws ServletException, IOException {
      sendPageHeader(response); 

      capacity = Integer.parseInt(request.getParameter("capacity")); 
      day = request.getParameter("day"); 
      time = request.getParameter("time"); 
      room = request.getParameter("room"); 
      user_id = Integer.parseInt(request.getParameter("user_id")); 
      subject_id = Integer.parseInt(request.getParameter("subject_id")); 


      boolean error = false; 
      String message = null; 
      try {
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = 
            DriverManager.getConnection("jdbc:mysql://localhost:3306/wae","root","");
        System.out.println("got connection"); 
        System.out.println(capacity);
        System.out.println(day);
        System.out.println(time);
        System.out.println(room);
        System.out.println(subject_id);
        System.out.println(user_id);
        Statement s = con.createStatement(); 

        String sql = "SELECT id FROM user" + 
                " WHERE id='" + user_id + "'";  
        ResultSet rs = s.executeQuery(sql); 
        if (rs.next()) {
          rs.close(); 
           sql = "INSERT INTO lab" + 
                  " (capacity, day, time, room, subject_id, user_id)" + 
                  " VALUES" + 
                  " ('" +  capacity + "'," + 
                     " '"  +  day + "'," + 
                     " '"  +  time + "'," + 
                     " '"  + room + "','" + subject_id + "','" + user_id + "')"; 

          System.out.println(sql);
          int i = s.executeUpdate(sql); 
          if (i==1) {
            message = "Successfully a new lab class."; 
          } 
        } 
          s.close(); 
          con.close(); 
        } 
        catch (SQLException e) {
          message = "Error." + e.toString(); 
          error = true; 
        } 
        catch (Exception e) {
          message = "Error." + e.toString(); 
          error = true; 
        } 
        if (message!=null) {
          PrintWriter out = response.getWriter(); 
          out.println("<B>" + message + "</B><BR>"); 
          out.println("<HR><BR>"); 
        } 
        if (error==true) 
          sendRegistrationForm(request, response, true); 
        else 
          sendRegistrationForm(request, response, false); 
        sendPageFooter(response); 
      } 

      /** 
       * Send the HTML page header, including the title 
       * and the <BODY> tag 
       */ 
      private void sendPageHeader(HttpServletResponse response) 
        throws ServletException, IOException {
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
        out.println("<HTML>"); 
        out.println("<HEAD>"); 
        out.println("<TITLE>Create Lab Page</TITLE>"); 
        out.println("</HEAD>"); 
        out.println("<BODY>"); 
        out.println("<CENTER>"); 
      } 

      /** 
       * Send the HTML page footer, i.e. the </BODY> 
       * and the </HTML> 
       */ 
      private void sendPageFooter(HttpServletResponse response) 
        throws ServletException, IOException {
        PrintWriter out = response.getWriter(); 
        out.println("</CENTER>"); 
        out.println("</BODY>"); 
        out.println("</HTML>"); 
      }   
      /**Send the form where the user can type in 
       * the details for a new user 
       */ 
      private void sendRegistrationForm(HttpServletRequest request, 
        HttpServletResponse response, boolean displayPreviousValues) 
        throws ServletException, IOException {

        PrintWriter out = response.getWriter(); 
        out.println("<BR><H2>Create A Lab</H2>"); 
        out.println("<BR>Please enter the lab details."); 
        out.println("<BR>"); 
        out.println("<BR><FORM METHOD=POST>"); 
        out.println("<TABLE>"); 
        out.println("<TR>"); 
        out.println("<TD>Class Capacity</TD>"); 
        out.print("<TD><INPUT TYPE=TEXT Name=capacity"); 

        if (displayPreviousValues) 
          out.print(" VALUE=\"" + capacity + "\""); 

        out.println("></TD>"); 
        out.println("</TR>"); 
        out.println("<TR>"); 
        out.println("<TD>Day</TD>"); 
        out.print("<TD><INPUT TYPE=TEXT Name=day"); 

        if (displayPreviousValues) 
          out.print(" VALUE=\"" + day + "\""); 

        out.println("></TD>"); 
        out.println("</TR>"); 
        out.println("<TR>"); 
        out.println("<TD>Time</TD>"); 
        out.print("<TD><INPUT TYPE=TEXT Name=time"); 

        if (displayPreviousValues) 
          out.print(" VALUE=\"" + time + "\""); 

        out.println("></TD>"); 
        out.println("</TR>"); 
        out.println("<TR>"); 
        out.println("<TD>Room</TD>"); 
        out.print("<TD><INPUT TYPE=TEXT Name=room");
        if (displayPreviousValues) 
            out.print(" VALUE=\"" + room + "\"");
        out.println("></TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>subject_id</TD>");
        out.print("<TD><INPUT TYPE=TEXT Name=subject_id");
        if (displayPreviousValues) 
            out.print(" VALUE=\"" + subject_id + "\"");
        out.println("></TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>user_id</TD>");
        out.print("<TD><INPUT TYPE=TEXT Name=user_id");
        out.println("></TD>");
        out.println("</TR>");

        if (displayPreviousValues) 
        out.print(" VALUE=\"" + user_id + "\""); 
        out.println("</TD>"); 
        out.println("</TR>");

        out.println("<TR>"); 
        out.println("<TD><INPUT TYPE=RESET></TD>"); 
        out.println("<TD><INPUT TYPE=SUBMIT></TD>"); 
        out.println("</TR>"); 
        out.println("</TABLE>"); 
        out.println("</FORM>"); 
        out.println("<BR>"); 
        out.println("<BR>"); 
      }
      }