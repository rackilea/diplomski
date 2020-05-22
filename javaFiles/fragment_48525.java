public class AcitivtyUtil {
    public static void showActivity(Activity from, Class<?> to, boolean finish) {
        Intent intent = new Intent(from, to);
        from.startActivity(intent);
        if (finish) {
            from.finish();
        }
    }
}