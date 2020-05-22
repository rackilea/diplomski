public class ActivityUtil {

private static Class getActivityClass(Class clazz) {

    // Check for extended activity
    String extClassName = clazz.getName() + "Extended";
    try {
        Class extClass = Class.forName(extClassName);
        return extClass;
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        // Extended class is not found return base
        return clazz;
    }
}

public static Intent createIntent(Context context, Class clazz) {
    Class activityClass = getActivityClass(clazz);
    return new Intent(context, activityClass);
}
}