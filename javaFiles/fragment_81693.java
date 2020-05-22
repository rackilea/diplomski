public static void check(List<?> list) {
    // check null
    if (Objects.equals(null, list)) 
        System.out.println("null");
    // check empty
    else if (list.isEmpty())
        System.out.println("empty");
    // if the list is ok, let's see what it has inside
    else if (list.get(0) instanceof Integer)
        System.out.println("int");
    else if (list.get(0) instanceof Double)
        System.out.println("double");
}