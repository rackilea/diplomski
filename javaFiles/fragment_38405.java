public Strategy prepare(String clazz, Properties config) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    Class<?> clazz = Class.forName(clazz);
    Strategy strategy = (Strategy) clazz.newInstance();
    strategy.initialise(config);
    return strategy;
}