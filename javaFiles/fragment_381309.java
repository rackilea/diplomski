public static < E > void sumOfGenericValues(E obj1, E obj2) {
        System.out.println(obj1.getClass());
        if(obj1 instanceof String) {
            System.out.println(((String)obj1).length());
        }
 }