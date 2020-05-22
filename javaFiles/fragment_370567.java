public class HomePage extends WebPage {

private String inputValue;

public HomePage(final PageParameters parameters) {
    super(parameters);

    final Label output = new Label("output", new PropertyModel<String>(
            this, "inputValue"));
    output.setOutputMarkupId(true);
    add(output);

    Form form = new Form("form");
    form.add(new AjaxSubmitLink("submit") {
        @Override
        protected void onAfterSubmit(AjaxRequestTarget target, Form<?> form) {
            super.onAfterSubmit(target, form);
            target.add(output);
        }
    });
    add(form);

    form.add(new TextField<String>("input", new PropertyModel<String>(this,
            "inputValue")));
}
}