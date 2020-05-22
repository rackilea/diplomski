PropertyModel pm = new PropertyModel(item.getModel(), "active");
item.add(new Label("active", new AbstractReadOnlyModel(){
    public Object getObject() { 
        if (Boolean.TRUE.equals(pm.getObject()) { return "enabled"; }
        else if (Boolean.FALSE.equals(pm.getObject()) { return "disabled"; }
        else { return null; }
    }
}));