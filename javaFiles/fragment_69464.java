public class PieChart extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init() throws ServletException {
        super.init();
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (InstantiationException e) {
            throw new ServletException(e);
        } catch (IllegalAccessException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String background = request.getParameter("background");
        // do some checks on colour here
        // such as null check and checking it is a valid colour value for your
        // chart

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db", "user", "password");
            JDBCPieDataset dataset = new JDBCPieDataset(connection);
            dataset.executeQuery("Select * From my_table");
            JFreeChart chart = ChartFactory.createPieChart("Pie Chart", dataset, true, false, false);

            if ("blue".equals(background)) {
                chart.setBackgroundPaint(Color.blue)
            }

            // why the null test? can chart ever be (sensibly) null?
            if (chart != null) {
                response.setContentType("image/png");
                OutputStream out = response.getOutputStream();
                ChartUtilities.writeChartAsPNG(out, chart, 450, 400);
            }
        } catch (SQLException e) {
            log("Exception retrieving chart data", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    log("Could not close Connection", e);
                }
            }
        }
    }
}