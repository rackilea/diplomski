public class WeatherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public WeatherServlet(){

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("again");
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("akshay rahar");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}