public class ThemedResourceViewResolver extends InternalResourceViewResolver {
@Autowired
private SitePropertyDAO sitePropertyDAO;

    protected String getPrefix() {
        String prefix = "/pages/" + Properties.THEME_NAME + "/";
        SiteProperty property = sitePropertyDAO.findOneByName(Constants.THEME);
        if (property != null) {
            prefix = "/pages/" + property.getContent() + "/";
        }
        return prefix;
    }
}