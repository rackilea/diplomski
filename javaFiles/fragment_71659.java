public static <D extends BaseClass> boolean doIt (ArrayList<D> target)
 {
    try {
        D newElem1 =  ((Class<D>) ((ParameterizedType) target.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getDeclaredConstructor(int.class).newInstance(5);

    } catch (Exception e) { e.printStackTrace();}

    return true ;
    }
}