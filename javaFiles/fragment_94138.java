public class JdbcServlet extends HttpServlet {

    private DataSource pool;

    @Override
    public void init(ServletConfig config) throws ServletException {        
        Context env = null;
        try {
            env = (Context) new InitialContext().lookup("java:comp/env");
            pool = (DataSource) env.lookup("sample");   //nombre en web.xml
            if (pool == null) {
                throw new ServletException("No se encontró el DataSource");
            }
        }   catch (NamingException ex) {
            Logger.getLogger(JdbcServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }          

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection conexion = null;
        ResultSet resultSet = null;

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Lista de amigos</h1>");
            try {                
                conexion = pool.getConnection();
                Statement statement = conexion.createStatement();
                String sql = "SELECT * FROM personas";
                ResultSet res = statement.executeQuery(sql);
                if (res.next()) {                                            
                    do {
                       out.println("<p>Nombre: "+res.getString("nombre")+
                               "<br/>Edad:"+res.getInt("edad")+"</p>");
                    } while (res.next());
                } else {
                    out.println("<p>No hay amigos dados de alta</p>");
                }   
                out.println("<a href='index.html'>Volver al inicio</a>");
            } catch (SQLException ex) {
                Logger.getLogger(JdbcServlet.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (conexion != null && !conexion.isClosed())
                        conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JdbcServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");

        if (nombre != null && edad != null) {
            Connection conexion = null;
            Statement statement = null;
            try {
                int numEdad = Integer.parseInt(edad);
                String sql = "INSERT INTO personas VALUES('"+nombre+"',"+numEdad+")";
                conexion = pool.getConnection();
                statement = conexion.createStatement();
                statement.executeUpdate(sql);                
                doGet(request, response);
            } catch (NumberFormatException | SQLException ex) {
                Logger.getLogger(JdbcServlet.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (conexion != null && !conexion.isClosed())
                        conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JdbcServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}