public class MyHandler extends IoHandlerAdapter{
    private enum AttributeKeys {
        KEY_UNIQUEID;
    }
    public void sessionCreated(IoSession session) throws Exception {
        //create and remember a uniqueID upon session creation
        session.setAttribute(AttributeKeys.KEY_UNIQUEID, createUniqueID());
    }

    //called with the regular IoSession
    public void messageReceived(IoSession session, Object message) throws Exception {
        //wherever you need the UniqueID, use getSessionUniqueID(session);
    }

    public String getSessionUniqueID(session){
       return session.getAttribute(AttributeKeys.KEY_UNIQUEID).toString();
    }
}