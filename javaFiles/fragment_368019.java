public BeanModel getAdminTableModel() {
        BeanModel<Admin> model;
        model = beanModelSource.createDisplayModel(Admin.class, messages);
        ...
        return model;
}