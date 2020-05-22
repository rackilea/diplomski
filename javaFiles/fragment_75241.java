@Override
    public void setFocus() {
        switch (getActivePage()) {
        case 0:
            pageOne.setUndoRedoActionHandlers();
            break;
        case 1:
            pageTwo.setUndoRedoActionHandlers();
            break;
        }   
        super.setFocus();
    }