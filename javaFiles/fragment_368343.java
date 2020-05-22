public class Presenter {

    private IModel model;
    private IView view;

    public Presenter(final IModel model, final IView view) {
        this.model = model;
        this.view = view;

        model.addModelChangeListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                view.setText(model.getText());
            }
        });
    }
}