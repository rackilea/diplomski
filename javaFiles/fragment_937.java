Element name = properties.getChild(DATASERVICES_NAMESPACE, "Name"); // 'Name' instead of 'name'
name.setEndTextElementListener(new EndTextElementListener(){
    public void end(String body){
        messages.add(body);
    }
});