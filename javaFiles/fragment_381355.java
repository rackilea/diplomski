@SpringBootApplication
public class App extends AbstractJavaFxApplicationSupport {

    /**
     * Note that this is configured in application.properties
     */
    @Value("${app.ui.title:PJe Midia Monitor}")//
    private String windowTitle;



    public static void main(String[] args) {

        launchApp(App.class, VisaoView.class, args);
    }

}