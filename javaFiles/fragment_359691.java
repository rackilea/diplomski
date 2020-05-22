public class OuterClass
{
    private class InnerClass
    {
        public OuterClass getOuter()
        {
            return OuterClass.this;
        }
    }
}