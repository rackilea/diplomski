class Model<T> { 

    private T t; 
    private Class<T> tag;

    public Model(Class<T> tag) {
       this.tag = tag;
    }

    private void someMethod(){ 
       // use tag
    }  
}