public class HostServicesControllerFactory implements Callback<Class<?>,Object> {

    private final HostServices hostServices ;

    public HostServicesControllerFactory(HostServices hostServices) {
        this.hostServices = hostServices ;
    }

    @Override
    public Object call(Class<?> type) {
        try {
            for (Constructor<?> c : type.getConstructors()) {
                if (c.getParameterCount() == 1 && c.getParameterTypes()[0] == HostServices.class) {
                    return c.newInstance(hostServices) ;
                }
            }
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}