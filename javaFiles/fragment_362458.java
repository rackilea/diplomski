try {
    filmService.delete(id);
} catch (Exception e) {
    FacesContext.getCurrentInstance().addMessage("", 
            new FacesMessage("Removing dataset(ID:" + id + ") is not possible, 
                                                  because it's used in another dataset!"));
}