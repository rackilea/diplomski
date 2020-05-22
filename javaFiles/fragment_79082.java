public class BookServ extends HttpServlet {
        private static final long serialVersionUID = 1L;

        private String servletUID = null;

        public void init() throws ServletException {
            servletUID = ... generate a random String as UID ...
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
              ...
        }
    }