private Activity myContext;
public ExceptionHandler(Activity context) {
    this.myContext = context;
}
@Override
public void uncaughtException(Thread thread, Throwable ex) {
    // TODO Auto-generated method stub
    StringWriter stackTrace = new StringWriter();
    ex.printStackTrace(new PrintWriter(stackTrace));
    String report = stackTrace.toString();

    if(myContext instanceof MainActivity){

        System.gc();
        android.os.Process.killProcess(android.os.Process.myPid());

    }else{

        Intent intent = new Intent(myContext, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        myContext.startActivity(intent);
        System.gc();
        android.os.Process.killProcess(android.os.Process.myPid());

    }
}