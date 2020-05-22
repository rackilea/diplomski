public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    private Integer counter = 0;

    public HomePage(final PageParameters parameters) {
        final Label label = new Label("counter", new PropertyModel<Integer>(this, "counter"));
        label.setOutputMarkupId(true);
        add(label);
        Form form = new Form("form");
        form.add(new AjaxTimerFormSubmitBehavior(form, Duration.seconds(10)) {

            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                counter++;
                target.add(label);
            }

            @Override
            protected void onError(AjaxRequestTarget target) {
                // TODO Auto-generated method stub

            }
        });
        add(form);
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }
}