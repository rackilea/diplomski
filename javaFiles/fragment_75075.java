@Override
public void run(final MonolithConfiguration config,
                final Environment env) {
    ErrorPageErrorHandler eph = new ErrorPageErrorHandler();
    eph.addErrorPage(404, "/error/404");
    env.getApplicationContext().setErrorHandler(eph);
}