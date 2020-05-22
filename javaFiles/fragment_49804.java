public class Controller {
    private final String template;
    public Controller( String template ) {
        this.template = template;
    }
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.loadView(new cms.library.PageConfig()
                .setRequest(request)
                .setResponse(response)
                .setTemplate(template));
    }
}

@WebServlet(name = "EditServlet", urlPatterns = {"/content/edit"})
public class EditServlet extends cms.library.Controller {
    public EditServlet() {
        super("/content/edit");
    }
    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("posted");
        this.doGet(request, response);
    }
}