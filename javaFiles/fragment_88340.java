interface Updateable {
        int update();
    }

    public static <T extends Updateable> int update2(List<T> objects){
        for(T object : objects)
        {
            object.update();
        }
        return 0;
    }