for(Map.Entry obj1 : map1.entrySet()){
    for(Map.Entry obj2 : map2.entrySet()){
        System.out.println("OBJ 1 : "+obj1.getKey()+", "+((Teacher)obj1.getValue()).getName()+", "+((Teacher)obj1.getValue()).getAge());
        System.out.println("OBJ 2 : "+obj2.getKey()+", "+((Teacher)obj2.getValue()).getName()+", "+((Teacher)obj2.getValue()).getAge());
    }
}