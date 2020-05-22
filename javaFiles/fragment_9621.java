public class B {
Context context;

public B(Context context) {
    this.context = context;

}

public void startNewActivity(String str) {
    try {
        Intent i = new Intent(context, Class.forName(str));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
}