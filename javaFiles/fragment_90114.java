private Classy(){ /*... */ }

public void instantiate(){
    if(instance != null) return;
    instance = new Classy();
}