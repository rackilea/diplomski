public static boolean isEmpty(Object test){
    if (test==null){
        return true;
    }
    if (test.getClass().isArray()){
        return 0 == Array.getLength(test);
    }
    if (test instanceof String){
        String s=(String)test;
        return s.isEmpty(); // Change this!!
    }
    if (test instanceof Collection){
        Collection c=(Collection)test;
        return c.isEmpty();
    }
    return false;
}