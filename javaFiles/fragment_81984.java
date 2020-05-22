public class MyWidget
{
    private final Foo someObject; 
    // ... more stuff


    private MyWidget(Builder builder)
    {
        this.someObject = builder.someObject;
        // ... more stuff
    }

    public static class Builder
    {
        Foo someObject;

        public Builder() {}

        public Builder withFoo(Foo someObject)
        {
            this.someObject = someObject;
            return this;
        }

        public MyWidget build()
        {
            return new MyWidget(this);
        }
    }
}