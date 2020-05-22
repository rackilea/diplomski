@WebServlet("/portal")    
    @MultipartConfig
    public class SelfserviceServlet extends HttpServlet {

            @Override
            protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
                view.forward(request, response);
            }

            @Override
            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String ip_address = request.getParameter("someparam");
                String port = request.getParameter("someotherparam");

                // Do some operation here to produce html_output

                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(html_output.toString());
            }
        }