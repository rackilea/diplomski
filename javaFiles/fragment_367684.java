form.add(new AjaxLink<Void>("updateContract"){

    @Override
    public void onClick(AjaxRequestTarget target) {
        form.setModelObject(service.get(1));
        target.add(form);  
    }
});