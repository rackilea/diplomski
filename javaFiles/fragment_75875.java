import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.guice.GuiceComponentInjector;

public class NavigatorApplication extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return Startpage.class;
    }

    @Override
    protected void init() {
        super.init();
                Injector injector = Guice.createInjector(new WebAppModule());
                addComponentInstantiationListener(
                                new GuiceComponentInjector(this, injector));    
    }

}