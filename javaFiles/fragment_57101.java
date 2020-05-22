public class WorkThreadLocal {

    public static ThreadLocal<String> id = new ThreadLocal<String>(){
        @Override
        protected String initialValue()
        {
            return "";
        }
    };

}