public static Stack METHOD_NAME(Object setName, int setLength){
    while(true) {
        try {
            return new Stack(setLength);
        } catch (InstantiationException e){
            System.err.println(e.getMessage());
            SET_NUM(1);
        }
    }
}