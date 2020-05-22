static class MyLogger{
        public static void d(String tag,Object o){
            if(o==null){
                throw new NullPointerException("The second parameter can not be null");
            }
            Log.d(tag, o.toString());
        }
    }