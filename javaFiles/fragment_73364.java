@WebServlet(name="SingletonTester", urlPatterns={"/SingletonTester"})
public class SingletonTester extends HttpServlet {

    @EJB
    MasterDataCache masterDataCache;

    @Override
    public void init(){
     masterDataCache.store("startup", new Date());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            out.println("Startup time: " + masterDataCache.get("startup") );
        } finally {
            out.close();
        }
    }
}