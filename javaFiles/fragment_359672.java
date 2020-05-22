public class Multiply implements Controller {

    public static String getURLTotal(HttpServletRequest req) {
        String scheme = req.getScheme();            // http
        String serverName = req.getServerName();    // hostname.com
        int serverPort = req.getServerPort();       // 80
        String contextPath = req.getContextPath();  // /mywebapp
        String servletPath = req.getServletPath();  // /servlet/MyServlet
        String pathInfo = req.getPathInfo();        // /a/b;c=123
        String queryString = req.getQueryString();  // d=789

        String[] item = queryString.split("&");
        int product = 1;
        for (int i = 0; i < item.length; i++) {
            String[] s = item[i].split("=");

            String name = s[0];
            String value = s[1];
            int numValue = Integer.parseInt(value);
            product = product * numValue;

        }
        return Integer.toString(product);
    }

    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response)
                 throws ServletException, IOException 
    {
        String Mess = Multiply.getURLTotal(request);

        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", Mess);

        return modelAndView;
    }
}