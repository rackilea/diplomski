public class DebugStack {
    private int x = 0;
    private void m1(){
        x++;
        m2();
    }
    private void m2(){
        x+=3;         
    }
    private boolean insideMethod(String methodName){
        for (StackTraceElement stackTrace : Thread.currentThread().getStackTrace()) {
            if (stackTrace.getMethodName().equals(methodName)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        DebugStack dbg = new DebugStack();
        dbg.m1();
        dbg.m2();

    }
}