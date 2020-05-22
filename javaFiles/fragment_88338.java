public static <T> int update(List<T> objects){
        for(T object : objects)
        {
            if(object.getClass().isInstance(Pair.class))
            {
                //do something
            }else if(object.getClass().isInstance(Time.class))
            {

            }
        }
        return 0;
    }