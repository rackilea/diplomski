@WebFilter(filterName = "cayenne-config", displayName = "cayenne-config", urlPatterns = {"/*"})
public class TestFilter extends CayenneFilter
{
    @Override
    public void init(FilterConfig config) throws ServletException
    {
        this.checkAlreadyConfigured(config.getServletContext());
        this.servletContext = config.getServletContext();
        WebConfiguration configAdapter = new WebConfiguration(config);
        Collection modules = configAdapter.createModules(new Module[]{new WebModule()});
        ServerRuntime runtime = new ServerRuntime("cayenne-test.xml", (Module[])modules.toArray(new Module[modules.size()]));
        WebUtil.setCayenneRuntime(config.getServletContext(), runtime);
    }
}