import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class for Servlet: DBinsert
 *
 */
 @WebServlet(name = "DBinsert", urlPatterns = { "/DBinsert" })
 public class DBinsert extends HttpServlet {
   static final long serialVersionUID = 1L;

    /* (non-Java-doc)
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public DBinsert() {
        super();
    }       

    /* (non-Java-doc)
     * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

String fname=request.getParameter("fname");
String sname=request.getParameter("sname");
String user=request.getParameter("uname");
String pwd=request.getParameter("pwd");
String email=request.getParameter("email");
String phone=request.getParameter("phone");
/*int ph=Integer.parseInt(phone);

if (phone.length()!=10) 
        {
    JOptionPane.showMessageDialog(null,"errormsg" );
            String e="Check phone number ";

            request.setAttribute("errormsg", e);
            request.getRequestDispatcher("SignNIIT.jsp").forward(request, response);
        }
        else
        */{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
                        String code="insert into prct.db (lastname,username,password) values (?,?,?)";
                        PreparedStatement ps=con.prepareStatement(code);
                        //ps.setString(1, fname);
                        ps.setString(1, sname);
                        ps.setString(2, user);
                        ps.setString(3, pwd);
                        //ps.setString(5, email);
                        //ps.setString(6, phone);
                        ps.executeUpdate();
                        //JOptionPane.showMessageDialog(null, "Sucessfull");
                    String msg="!!! Registered Sucessfully !!! ";
                        request.setAttribute("data", msg);
                        request.getRequestDispatcher("SignU.jsp").forward(request, response);

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
}