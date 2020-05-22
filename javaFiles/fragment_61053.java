public static <T> EndpointProvider<T> getProvider(Class<T> klass)
{
    if (klass.isAssignableFrom(RecommendationCategory.class))
    {
        return new EndpointWrapper<T>(klass.cast(new RecommendationCategory()));
    }

    return null;
}

private static class EndpointWrapper<X> implements EndpointProvider<X>
{
    public EndpointWrapper(X wrapper)
    {

    }
}

private static class RecommendationCategory
{

}

private static interface EndpointProvider<T>
{

}