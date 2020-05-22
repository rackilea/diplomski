public class FormFactory {

private ApplicationContext context;
private static FormFactory viewFactory;

private FormFactory() {
    if (context == null) {
        context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    }
}

public static synchronized FormFactory getInstance() {
    if (viewFactory == null) {
        viewFactory = new FormFactory();
    }
    return viewFactory;

}

public BaseView createForm(Type type) {
    BaseView form = null;
    switch (type) {
        case FIRST:
            form = (BaseView) context.getBean("firstForm");
            break;
        case SECOND:
            form  = (BaseView) context.getBean("secondForm");
            break;
        default:
            break;
    }
    return form;

}
}