Callback<Class<?>, Object> controllerFactory = new Callback<Class<?>, Object>() {

    SubController1 a = new SubController1();
    SubController2 b = new SubController2();
    MainController c = new MainController(a, b);

    @Override
    public Object call(Class<?> type) {
        if (type == SubController1.class) {
            return a ;
        }
        if (type == SubController2.class) {
            return b ;
        }
        if (type == MainController.class) {
            return c ;
        }
        return null ;
    }
};