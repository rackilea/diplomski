@Component
public class YourViewPreparer implements ViewPreparer {
    @Autowired
    private UserService userService;

    @Override
    public void execute(TilesRequestContext tilesContext, AttributeContext attributeContext) {
        // Some magic here to get the HttpRequest...
        Object[] requestObjects = tilesContext.getRequestObjects();
        if (requestObjects.length == 2) {
            HttpServletRequest request = (HttpServletRequest) requestObjects[0];
            User user = userService.getCurrentUser();
            request.setAttribute("isLoggedIn", user != null);
        }
    }
}