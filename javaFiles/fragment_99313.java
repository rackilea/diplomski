public static void main(String[] args) throws Exception{
            Constructor cd = Test.class.getConstructor(Object[].class);
            Object[] objs = {1, 2, 3, 4, 5, 6, 7, 8};
            Object[] passed = {objs};
            cd.newInstance(passed);
    }