public static class MyClassProvider implements Provider<MyClass>
{
    private HttpServletRequest request;

    @Inject
    public MyClassProvider(@Context HttpServletRequest request)
    {
        this.request = request;
    }

    @Override
    public MyClass get()
    {
        return new MyClass(request);
    }
}