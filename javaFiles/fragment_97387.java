class  GenericClass <E>{
    void genericFunction(List<E> stringList) {
        ...
    }
    // some other code
}

...

GenericClass<String> genericClass=new GenericClass<String>(); // Genreric object
List<Integer> integerList= new ArrayList<Integer>();
integerList.add(100);
genericClass.genericFunction(integerList); // compile time error