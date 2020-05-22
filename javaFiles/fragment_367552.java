public class FatherServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Father father1 = new Father();
        Father father2 = new Father();
        father1.incrementCount();
        request.setAttribute("father2", father2); // Will be available in JSP as ${father2}
        request.getRequestDispatcher("/WEB-INF/father.jsp").forward(request, response);
    }
}