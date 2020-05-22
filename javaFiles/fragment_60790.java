public void search(ComponentSystemEvent event) {   
    if (FacesContext.getCurrentInstance().isPostback()) {
        return;
    }

    // ...
}