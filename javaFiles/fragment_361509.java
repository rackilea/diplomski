package sshUploader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Run several ssh commands in a single JSch session
 */
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;

/**
 * Servlet implementation class TailLogServlet
 */
@WebServlet(description = "This servlet tails the remote logs", urlPatterns = { "/TailLogServlet" })
public class TailLogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TailLogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try  
        {  
            //System.out.println("*************GETTT TailLogServlet Hit. logFileName :"+request.getParameter("logFileName"));

          PrintWriter pw=response.getWriter();  
          response.setContentType("text/html"); 
          response.setHeader("Cache-Control", "no-cache");

          JSch jsch = new JSch();
          String user = request.getParameter("logUID");            //CHANGE ME
          String host = request.getParameter("host");//CHANGE ME
          String passwd = request.getParameter("logPwd");      //CHANGE ME
          int port = 22;    
          Session session = jsch.getSession(user, host, port);
          session.setPassword(passwd);

          Hashtable<String, String> hashtable  = new Hashtable<String, String>();
          hashtable.put("StrictHostKeyChecking", "no");
          session.setConfig(hashtable);

          session.connect();

          Channel channel = session.openChannel("shell");
          OutputStream ops = channel.getOutputStream();
          PrintStream ps = new PrintStream(ops, true);

          channel.connect();
          InputStream input = channel.getInputStream();

           ps.println("tail -f "+request.getParameter("logFileName"));
          ps.close();

          int SIZE = 1024;
          byte[] tmp = new byte[SIZE];
          long startTime = System.currentTimeMillis();
          while ((System.currentTimeMillis()-startTime)< 3*1000){
             while (input.available() > 0)
             {
                int i = input.read(tmp, 0, SIZE);
                if(i < 0)
                   break;
                 System.out.println(new String(tmp, 0, i)); 
                 pw.println(new String(tmp, 0, i));
             }          
             pw.flush();             
         }


        }catch(Exception e)  
        {  
             e.printStackTrace();  
        } 
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //System.out.println("*************POSTTTTT TailLogServlet Hit. logFileName :"+request.getParameter("logFileName"));
        doGet(request, response);
    }
}