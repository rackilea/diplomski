public <V> V getPropertiesByObject(Class<V> sample, Object... params) throws TimeoutException {
    V result = sample.newInstance();
    result.param0 = params[0];
    result.param1 = params[1];
    // etc  
    return result;
}