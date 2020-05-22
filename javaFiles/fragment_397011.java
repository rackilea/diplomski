private static volatile Class mClass  null;

public static Class getInstance(Context context){
    if(mClass == null){
        synchronized(Class.class){
            if(mClass == null){
                mClass = new Class(context);
            }
        }
    }
    return mClass;
}