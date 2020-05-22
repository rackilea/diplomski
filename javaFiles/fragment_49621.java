public class ContactsApplication extends SwaggerApplication {
    public Restlet createInboundRoot() {
        Router router = new Router();
        (...)
        attachSwaggerSpecificationRestlet(router, "/docs");

        return router;
    }
}