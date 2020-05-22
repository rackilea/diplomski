public Object get(String methodName, A a) throws Exception {
    Object ret = null;
    if(a != null){
        Class<A> cl = A.class;
        Method method = cl.getDeclaredMethod(methodName);
        ret = method.invoke(a);
    }
    return ret;
}

public void set(String methodName, Object value, A a) throws Exception{
    Class<A> cl = A.class;
    Method method = cl.getDeclaredMethod(methodName, value.getClass());
    method.invoke(a, value);

}