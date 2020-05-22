@Provider
public class JAXBContextResolver implements ContextResolver<JAXBContext> {
    private final static String ENTITY_PACKAGE = "package.goes.here";
    private final static JAXBContext context;
    static {
        try {
            context = new JAXBContextAdapter(new JSONJAXBContext(JSONConfiguration.mapped().rootUnwrapping(false).build(), ENTITY_PACKAGE));
        } catch (final JAXBException ex) {
            throw new IllegalStateException("Could not resolve JAXBContext.", ex);
        }
    }

    public JAXBContext getContext(final Class<?> type) {
        try {
            if (type.getPackage().getName().contains(ENTITY_PACKAGE)) {
                return context;
            }
        } catch (final Exception ex) {
            // trap, just return null
        }
        return null;
    }

    public static final class JAXBContextAdapter extends JAXBContext {
        private final JAXBContext context;

        public JAXBContextAdapter(final JAXBContext context) {
            this.context = context;
        }

        @Override
        public Marshaller createMarshaller() {
            Marshaller marshaller = null;
            try {
                marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            } catch (final PropertyException pe) {
                return marshaller;
            } catch (final JAXBException jbe) {
                return null;
            }
            return marshaller;
        }

        @Override
        public Unmarshaller createUnmarshaller() throws JAXBException {
            final Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setEventHandler(new DefaultValidationEventHandler());
            return unmarshaller;
        }

        @Override
        public Validator createValidator() throws JAXBException {
            return context.createValidator();
        }
    }
}