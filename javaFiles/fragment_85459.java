public class AreaServlet extends HttpServlet {
    private AreaDAO areaDAO;

    public void init() throws ServletException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "user";
        String password = "pass";
        Database database = new Database(driver, url, username, password);
        this.areaDAO = new AreaDAO(database);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        try {
            List<Area> areas = areaDAO.list();
            request.setAttribute("areas", areas);
            request.getRequestDispatcher("/WEB-INF/areas.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Cannot retrieve areas", e);
        }
    }
}