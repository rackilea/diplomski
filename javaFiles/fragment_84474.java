public class MyAuthenticator extends Authenticator {

public MyAuthenticator(Context context) {
    super(context);
}

@Override
protected boolean authenticate(Request request, Response response) {
    // do your custom authentication here and return true or false depending on result
}