public class RealLoginController implements LoginController {
    private LoginViewFactory viewFactory;

    public LoginController(LoginViewFactory viewFactory) {
        this.viewFactory = viewFactory;
    }

    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) {
         if (isLoggedIn()) {
             return viewFactory.createLoggedInView();
         } else {
             return viewFactory.createLoggedOutView();
        }
    }

    // ...
}

public class RealLoggedInView implements LoginView {
    // Implementation for rendering stuff
}

public class RealLoggedOutView implements LoginView {
    // Implementation for rendering stuff
}


public interface LoginViewFactory {
    public LoginView createLoggedInView();
    public LoginView createLoggedInView();
}


public class RealLoginViewFactory implements LoginViewFactory {
    private FooModel fooEngine;
    private BarConfig barConfig;

    public RealLoginViewFactory(FooModel fooLayer, BarConfig barConfig) {
        this.fooEngine = fooEngine;
        this.barConfig = barConfig;
    }

    public LoginView createLoggedInView() {
        if (fooEngine.hasBaz()) {
            return new RealLoginView(barCongig.getQux());
        } else {
            return new RealLoginView(barCongig.getQux(),
                                     fooEngine.getBaz());
        }
    }

    public LoginView createLoggedOutView() {
        // ...
    }
}

public class RealLoginController implements LoginController {
    private LoginViewFactory viewFactory;

    public LoginController(LoginViewFactory viewFactory) {
        this.viewFactory = viewFactory;
    }

    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) {
         if (isLoggedIn()) {
             return viewFactory.createLoggedInView();
         } else {
             return viewFactory.createLoggedOutView();
        }
    }

    // ...
}