@Provider
public class MyJAXBContextProvider implements ContextResolver<JAXBContext> {

    private JSONJAXBContext trackCtx;

    public MyJAXBContextProvider() throws JAXBException {
        trackCtx = new JSONJAXBContext(JSONConfiguration.mappedJettison().build(), Track.class);
    }

    public JAXBContext getContext(Class<?> type) {
        if(type == Track.class) {
            return trackCtx;
        }

        return null;
    }

}