@Route(value = "accessDenied")
public class DeniedAccessView
        extends VerticalLayout {
    DeniedAccessView() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(new Label("Access denied!"));
        add(formLayout);
    }
}