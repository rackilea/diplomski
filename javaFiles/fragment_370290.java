public class FormPanelX extends Composite {

private static FormPanelXUiBinder uiBinder = GWT
        .create(FormPanelXUiBinder.class);

interface FormPanelXUiBinder extends UiBinder<Widget, FormPanelX> {
}

public FormPanelX() {
    initWidget(uiBinder.createAndBindUi(this));
}

@UiField
FormPanel formPanel;

@UiField
TextBox textField;

private HandlerRegistration handlerRegistration;

public FormPanelX(String firstName) {
    initWidget(uiBinder.createAndBindUi(this));
}

public TextBox getTextField() {
    return textField;
}

public void setTextField(TextBox textField) {
    this.textField = textField;
}   
}