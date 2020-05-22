@Override
public void init() throws ServletException {
    try {
        securityController = SecurityControllerFactory.getInstance().create();
    } catch (Exception e) {
        throw new ServletException("Error creating security controller", e);
    }

    maxFileSize = getBytes(10);
    maxMemSize = getBytes(2);
}