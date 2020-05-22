private String returnDetailPageName(TrainObj entityObj) {
        Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        TrainForm formBean = new TrainForm();
        formBean.setMe(entityObj); //setter for the entity vproperties
        session.put(formBeanName , formBean);
        return "goProdTraining"; //go to detail page
    }