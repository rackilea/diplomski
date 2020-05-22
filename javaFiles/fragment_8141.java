class MyObject{}
class Human extends MyObject{}

public <T extends MyObject> ConcurrentSkipListMap<String, T> get(Class<T> clazz, Object... vars){
    //...

    return null;
}

//use the get() with
void hello(){
    ConcurrentSkipListMap<String, Human> x = get(Human.class, "Adam");
}