@Override
public void renderHead(IHeaderResponse response) {

    try {
        InputStream in = new CssPackageResource(BusinessMail.class, 
                "style.css", getLocale(), "?", "?")
                .getCacheableResourceStream().getInputStream();

        String data = new java.util.Scanner(in).useDelimiter("\\A").next();
        response.renderCSS(data, "notneeded");

    } catch (ResourceStreamNotFoundException e) {
        logger.error("Could not load css", e);
    }           
}