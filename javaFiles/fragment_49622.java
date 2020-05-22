public class ContactsApplication extends Application {
   public Restlet createInboundRoot() {
        Router router = new Router();
        (...)
        Swagger2SpecificationRestlet swagger2SpecificationRestlet
                               = new Swagger2SpecificationRestlet(this);
        swagger2SpecificationRestlet.setBasePath("http://myapp.org/");
        swagger2SpecificationRestlet.attach(router, "/docs");
        return router;
    }
}