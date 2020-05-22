@Override
public String processCall(String payload) throws SerializationException {

    if(!userIsAuthorized()){
        return RPC.encodeResponseForFailure(null, new MyAuthorizationException());
    }

    return super.processCall(payload);
}