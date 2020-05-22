private static Map<Integer, String> map = null;

public synchronized static String getString(int parameter){

    if(map == null){

        map = new HashMap<Integer, String>();
        //map gets filled here...

    }

    return map.get(parameter);
}