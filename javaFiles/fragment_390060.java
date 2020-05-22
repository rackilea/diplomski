private GenericViewModel<? extends AbstractDatabaseObject> model;
private IGenericView view;

public GenericPresenter(GenericViewModel<? extends AbstractDatabaseObject> model, 
                        IGenericView view) {
    this.model = model;
    this.view = view;
    view.addListener(this);
}