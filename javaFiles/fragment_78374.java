public static void print(List<? extends Object> list) {
    for (Object t : list) {
        if(t instanceof T) System.out.println(((T)t).getValue());
        else if (t instanceof List) print((List) t);
        else continue; // I don't know this type.
    }
}