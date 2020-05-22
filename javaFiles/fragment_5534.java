public class MapServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do Get");
        Map<String, String> values = new HashMap<String, String>();
        values.put("1", "One");
        values.put("2", "Two");
        values.put("3", "Three");
        values.put("4", "Four");

        request.setAttribute("paramList", values);
        RequestDispatcher rd = request.getRequestDispatcher("youruipage.jsp");
        rd.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do Post");
        String keys[] = request.getParameterValues("attr");
        String values[] = request.getParameterValues("vals");

        for (String str1 : values) {
            System.out.println(" - " + str1);
        }

        for (String str2 : keys) {
            System.out.println(" - " + str2);
        }
    }

}