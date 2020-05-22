public class Test
{

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException
    {
        new Test().run();
    }

    private void run() throws IllegalAccessException, InvocationTargetException
    {
        Bean1 one = new Bean1();
        one.setProp1("Foo");

        Bean2 two = new Bean2();

        BeanUtils.copyProperties(two, one);

        System.out.println(ToStringBuilder.reflectionToString(one));
        System.out.println(ToStringBuilder.reflectionToString(two));
    }

    public class Bean1
    {
        private String propbean1;

        public String getProp1()
        {
            System.out.println("bean1 getter");
            return propbean1;
        }

        public void setProp1(String s)
        {
            System.out.println("bean1 setter");
            propbean1 = s;
        }
    }

    public class Bean2
    {
        private String propbean2;

        public String getProp1()
        {
            System.out.println("bean2 getter");
            return propbean2;
        }

        public void setProp1(String s)
        {
            System.out.println("bean2 setter");
            propbean2 = s;
        }
    }
}