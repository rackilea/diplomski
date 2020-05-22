class AClass<T extends SuperClass> {
    List<T> list;

    public AClass(){
        list = new ArrayList<T>();
    }

    void addObjects(T obj){
        list.add(obj);
    }

}