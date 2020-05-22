FXMLLoader loader = new FXMLLoader(getClass().getResource("path/to/fxml"));
MyService service = new MyServiceImpl();
loader.setControllerFactory((Class<?> type -> {
    try {
        // look for constructor taking MyService as a parameter
        for (Constructor<?> c : type.getConstructors()) {
            if (c.getParameterCount() == 1) {
                if (c.getParameterTypes()[0]==MyService.class) {
                    return c.newInstance(service);
                }
            }
        }
        // didn't find appropriate constructor, just use default constructor:
        return type.newInstance();
    } catch (Exception exc) {
        throw new RuntimeException(exc);
    }
});
Parent root = loader.load();
// ...