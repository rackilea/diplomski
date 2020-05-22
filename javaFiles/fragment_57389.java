/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package source;

    import java.io.IOException;
    import java.io.InputStream;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;
    import java.time.LocalDateTime;

    import javax.servlet.ServletException;
    import javax.servlet.annotation.MultipartConfig;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.Part;

    /**
     *
     * @author Farouk
     */
    @WebServlet(name = "bulkCheckServlet", urlPatterns = {"/bulkCheckServlet"})
    @MultipartConfig
    public class bulkCheckServlet extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

                String bulkname = request.getParameter("bulkname");
                String quota = request.getParameter("quota");//Integer.parseInt(request.getParameter("quota"));
                System.out.println(quota);
                String provider = request.getParameter("provider");

                InputStream inputStream = null; // input stream of the upload file

                // obtains the upload file part in this multipart request
                Part filePart = request.getPart("file");
                if (filePart != null) {
                    // prints out some information for debugging
                    System.out.println(filePart.getName());
                    System.out.println(filePart.getSize());
                    System.out.println(filePart.getContentType());

                    // obtains input stream of the upload file
                    inputStream = filePart.getInputStream();
                }

                Connection conn = null; // connection to the database
                String message = null;  // message will be sent back to client

                try {
                    // connects to the database
                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smsglobal", "root", "0168308330");

                    // constructs SQL statement
                    String sql = "INSERT INTO smsbulk (id,quota,provider,bulkname,date,file) values (?,?,?,?,?,?);";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setString(1, quota);
                    statement.setString(2, provider);
                    statement.setString(3, bulkname);
                    statement.setString(4, LocalDateTime.now().toString());
                    System.out.println(sql);

                    if (inputStream != null) {
                        // fetches input stream of the upload file for the blob column
                        statement.setBlob(5, inputStream);
                    }

                    // sends the statement to the database server
                    int row = statement.executeUpdate();
                    if (row > 0) {
                        message = "File uploaded and saved into database";
                    }
                } catch (SQLException ex) {
                    message = "ERROR: " + ex.getMessage();
                    ex.printStackTrace();
                } finally {
                    if (conn != null) {
                        // closes the database connection
                        try {
                            conn.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                    // sets the message in request scope
                    request.setAttribute("Message", message);

                    // forwards to the message page
                    getServletContext().getRequestDispatcher("/Campaign.jsp").forward(request, response);
                }
        }

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doGet(request, response);
        }
    }