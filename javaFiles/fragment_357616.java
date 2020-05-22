public class MySTErrorListener implements STErrorListener {
...
@Override
public void compileTimeError(STMessage msg) {
    // do something useful here, or throw new RuntimeException(msg.toString())
}
...
}