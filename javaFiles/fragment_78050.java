class YourTypeAdapter implements YourAdapterInterface{
    private Type instance; //need to adapt this as no interface present

    public void interfaceMethod(){
        instance.someTypeSpecificMethod();
        //perform extra steps here 
    }
}