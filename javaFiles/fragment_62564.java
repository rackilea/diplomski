@WebServlet(urlPatterns = { "/msg/locale", "/locale" }, loadOnStartup = 1 )
public class UnicodeTest extends HttpServlet {

    private static final long serialVersionUID = 5081877L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setCharacterEncoding("UTF-8");

        String unicodeMessage = URLDecoder.decode( request.getParameter("message"), "UTF-8");
                // request.getParameter("message"); // "×××©"
                //new String(request.getParameter("message").getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("Unicode Message :"+ request.getParameter("message") );

        try {
            System.out.println("windows-1255 : " + new String(unicodeMessage.getBytes("UTF-8"), "UTF-8") );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        UnicodeChars.insertAutoIncrement_SQL("Yash_777", "Telugu", unicodeMessage);

        PrintWriter writer = response.getWriter();
        if( unicodeMessage != null & !unicodeMessage.equals("") ) {
            writer.append("Received Message : "+ URLEncoder.encode( unicodeMessage, "UTF-8"));
        } else {
            writer.append("Not Received any Message.");
        }
        writer.flush();
        writer.close();
    }
}