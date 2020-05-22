class abstract Myclass {
 public String getUri(){
    // create a new instance of DefaultUri
    DefaultUri defaultUri = createDefaultUri();
    return "test"
 }

 protected abstract DefaultUri createDefaultUri();
}