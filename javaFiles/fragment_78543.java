public <A, B> B cast( A sourceObject, Class<B> targetClass )
{
    AutoBean<A> sourceBean = AutoBeanUtils.getAutoBean( sourceObject ); // Get the corresponding AutoBean.
    HasSplittable splittableBean = ( HasSplittable ) sourceBean;       // Implementation (if still AbstractAutoBean) supports this interface ;)
    Splittable splittable = splittableBean.getSplittable().deepCopy(); // If you don't copy it, decode() tries to be clever and returns
                                                                       // the original bean!
    AutoBean<B> targetBean = AutoBeanCodex.decode( typeFactory, targetClass, splittable ); // Create new AutoBean of
                                                                                           // the target type.
    return targetBean.as(); // Get the proxy for the outside world.
}