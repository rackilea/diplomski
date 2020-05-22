public interface View<C> {

    public JComponent getView();
    public void setController(C controller);
    public C getController();

}