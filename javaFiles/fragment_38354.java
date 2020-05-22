public <T> T invoke(Callable<T> function) {
    try {
        return function.call();
    } catch (UIException e) {
        notHealthy();
    } catch (HostException e) {
        notHealthy();
    } catch (Exception e) {
        Throwables.propagate(e);
    }
}

public String getTheStuff(final String client) {
    return invoke(new Callable<String>() {
        @Override
        public String call() {
            return extService.getProduct(client);
        }
    });
}

public CustomType getsomeMoreStuff(final String source, final int offset) {
    return invoke(new Callable<CustomType>() {
        @Override
        public CustomType call() {
            return extService.getMetrics(source, offset);
        }
    });
}