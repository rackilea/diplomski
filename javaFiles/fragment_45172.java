Boolean val = new Boolean(false);
if (value != null){
    val = (Boolean) value;
}
if (val.booleanValue()) {
    rendererComponent.setSelected(true);
}else{
     rendererComponent.setSelected(false);
}
return rendererComponent;