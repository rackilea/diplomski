private static final String HEADER_PROPERTY = "header-msg";  
private ValueMap properties = null;
private String headerMessage = null;
// What is going on with this line?  that doesn't compile.
//private static final String getHeader = this.properties.get(HEADER_PROPERTY, "");

public void setProperties(ValueMap properties){
this.properties = properties;
headerMessage = this.properties.get(HEADER_PROPERTY);
}

public String getHeaderMessage(){
return headerMessage;
}