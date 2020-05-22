public static void main(String[] args) throws Throwable {
    System.out.println(getGenericListItemType(B.class)); // class java.lang.String
    System.out.println(getGenericListItemType(A.class)); // class java.lang.String
    System.out.println(getGenericListItemType(D.class)); // class java.lang.Integer
}

private static final TypeVariable<?> listE = List.class.getTypeParameters()[0];

public static Class<?> getGenericListItemType(Class<?> cls) {  
    // method defined in 'Reflection' helper class      
    return Reflection.findTypeParameterValues(cls).get(listE);
}