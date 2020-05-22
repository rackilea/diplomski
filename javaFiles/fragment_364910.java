@Override
public String processCall(String payload) throws SerializationException {

    if(!userIsAuthorized()){
        throw new MyAuthorizationException();
    }

    return super.processCall(payload);
}