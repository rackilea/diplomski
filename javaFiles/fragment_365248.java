@WebServlet("/.../api/long/running/process/status")
public class LongRunningProcessStatusHandler extends HttpServlet  {
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException  {

    return request.getSession().getAttribute("LONG_RUNNING_PROCESS_STATUS").get();
}