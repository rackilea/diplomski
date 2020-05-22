class ExtendedTableFieldFactory implements TableFieldFactory{
    private static final long serialVersionUID = 1L;

    public Field createField(Container container, Object itemId, Object propertyId, Component uiContext){
        if(selectedRows != null){
            if(selectedRows.contains(itemId)){              
                return new com.vaadin.ui.TextField();
            }
        }
        return null;
    }
}


/**
 * Event handling for the table.
 * If one or more rows has been selected we set the corresponding action.
 * The action repaints the context menu.
 */ 
class ExtendedValueChangeListener implements Property.ValueChangeListener
{
    private static final long serialVersionUID = 1L;

    @Override
    public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
        setEditable(false);
        selectedRows = (Set<T>) event.getProperty().getValue();


        if(selectedRows == null || selectedRows.size() == 0){
            extActionHandler.setCurrentAction(ACTIONS_EDIT);        
        }else if(selectedRows.size() == 1){
            extActionHandler.setCurrentAction(ACTIONS_EDIT);        
            requestRepaint();
        }else{
            if(extActionHandler.getCurrentAction() != ACTIONS_EDIT_ALL)
            {                   
                extActionHandler.setCurrentAction(ACTIONS_EDIT_ALL);
                requestRepaint();
            }
        }
    }       
}


/**
 * The action handler is the context menu in the table.
 * We have a handler that takes the appropriate action on events.
 */
class ExtendedActionHandler implements Action.Handler{
    private static final long serialVersionUID = 1L;
    private Action[] currentAction = null;

    @Override
    public Action[] getActions(Object target, Object sender) {          
        System.out.println("calling GETACTIONS!");
        return currentAction;
    }

    @Override
    public void handleAction(Action action, Object sender, Object target) {
        System.out.println("calling handleActions aciton: "+action);
        if(action == ACTION_EDIT_ALL_MODAL){
            if (subwindow != null && subwindow.getParent() != null) {
                subwindow.focus();                  
            } else {          
                subwindow = new Window("Edit contacts");
                subwindow.setModal(true);

                VerticalLayout layout = (VerticalLayout) subwindow.getContent();
                layout.setMargin(true);
                layout.setSpacing(true);

                T data = selectedRows.iterator().next();
                try {
                    T dataEmpty = (T) data.getClass().newInstance();                        
                    modalForm.setItemDataSource(new BeanItem<T>(dataEmpty));

                } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


                subwindow.addComponent(modalForm);
                subwindow.setWidth("720px");
                subwindow.center();                 
                getParent().getWindow().addWindow(subwindow);

                //getWindow().addWindow(subwindow);

            }
        }else{
            setEditable(true);
        }       

    }       
    public Action[] getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(Action[] currentAction) {
        System.out.println("setting current action to: " + currentAction);
        this.currentAction = currentAction;

    }

}