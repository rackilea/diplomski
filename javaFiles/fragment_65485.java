public void initTableListeners(){
    extValueChangeListener = new ExtendedValueChangeListener();
    extMouseListener = new ExtendedMouseListener();
    extShortcutListener = new ExtendedShortcutListener("enter", KeyCode.ENTER);

    setTableListeners();
}

/**
 * Registers the default listeners to the table.
 */
public void setTableListeners(){        
    if(!hasListeners(extValueChangeListener.getClass())){           
        addListener(extValueChangeListener);
    }
    if(!hasListeners(extMouseListener.getClass())){         
        addListener(extMouseListener);
    }
    if(!hasListeners(extShortcutListener.getClass())){          
        addShortcutListener(extShortcutListener);
    }
}

/**
 * Clears the listeners registered to the table.
 */
public void clearTableListeners(){
        removeListener(extValueChangeListener);
        removeListener(extMouseListener);
        removeShortcutListener(extShortcutListener);

}

@Override
public EditTable getTable() {       
    return this;
}