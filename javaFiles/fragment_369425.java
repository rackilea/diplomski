I was also able to do this using this snippet. It works hopefully this has no side effects.

@Bean()
public ThreadLocal<DateFormat> dateFormatMMddyyyy()
{
    ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>()
    {
        @Override
        protected DateFormat initialValue()
        {
            return new SimpleDateFormat("MM/dd/yyyy");
        }
    };

    return threadLocal;
}