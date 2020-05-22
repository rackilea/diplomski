public class AuthenticationEvent extends GwtEvent<AuthenticationEventHandler> {

public static Type<AuthenticationEventHandler> TYPE = new Type<AuthenticationEventHandler>();

  @Override
public Type<AuthenticationEventHandler> getAssociatedType() {
    return TYPE;
}

@Override
protected void dispatch(AuthenticationEventHandler handler) {
    handler.onAuthenticationChanged(this);
}
}