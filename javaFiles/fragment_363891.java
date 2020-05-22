class yourList<T>{

    List<T> list = new LinkedList<>();

    void generic(String methodName, Object...args){
        for (Object obj: list) {
            try {

                Class<?>[] classes = new Class<?>[args.length];
                for (int i = 0; i < args.length; i++) {
                    classes[i] = args[i].getClass();
                }
                Method mtd = obj.getClass().getMethod(methodName, classes);
                mtd.invoke(obj, args);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}