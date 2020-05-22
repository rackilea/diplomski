public class TestJackRabbitCdn extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 4158924623219324725L;
    JackRabbitServiceImpl service=null;
    @Override
    public void init(){
        try {
            service=new JackRabbitServiceImpl();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,
    ServletException {
        response.setContentType("image/gif");
        try {
            response.getOutputStream().write(service.getContentRose());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.getOutputStream().flush();
    }

}