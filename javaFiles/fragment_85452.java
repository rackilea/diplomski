private static saeedHelperBD firstDB;
    public static synchronized saeedHelperBD getInstance() {
        if (firstDB == null) {
            firstDB = new saeedHelperBD(context);
        }
        return firstDB;
    }