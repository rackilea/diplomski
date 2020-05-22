public class JsfExceptionHandlerFactory extends ExceptionHandlerFactory {

    private ExceptionHandlerFactory factory;

    public JsfExceptionHandlerFactory(ExceptionHandlerFactory factory) {
        this.factory = factory;
    }

    /* (non-Javadoc)
     * @see javax.faces.context.ExceptionHandlerFactory#getExceptionHandler()
     */
    @Override
    public ExceptionHandler getExceptionHandler() {
        ExceptionHandler result = new JsfExceptionHandler(factory.getExceptionHandler());
        return result;
    }

}