public class AbstractController implements PropertyChangeListener {

Map<Type, BaseView> registeredViews;
Map<Type, AbstractModel> registeredModels;

public AbstractController() {
    registeredViews = new HashMap<Type, BaseView>();
    registeredModels = new HashMap<Type, AbstractModel>();
}

public void addModel(Type type, AbstractModel model) {
    registeredModels.put(type, model);
    model.addPropertyChangeListener(this);
}

public void removeModel(AbstractModel model) {
    registeredModels.remove(model);
    model.removePropertyChangeListener(this);
}

public void addView(BaseView view, Type type) {
    registeredViews.put(type, view);
}

public void removeView(javax.swing.JFrame view) {
    registeredViews.remove(view);
}

public void propertyChange(PropertyChangeEvent evt) {

    for (BaseView view : registeredViews.values()) {
        view.modelPropertyChange(evt);
    }
}

protected void setModelProperty(String propertyName, Object newValue) {
    for (AbstractModel model : registeredModels.values()) {
        Statement statment = new Statement(model, "set" + propertyName, new Object[] { newValue });
        try {
            statment.execute();
        } catch (NoSuchMethodException e) {
            continue;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}    
}