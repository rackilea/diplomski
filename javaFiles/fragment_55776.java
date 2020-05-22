public List getElements() {
    MenuModel model = getModel();
    if (model != null) {
        return model.getElements();
    }
    else {
        return getChildren();
    }
}