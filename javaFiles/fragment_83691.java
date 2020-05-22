@UpnpStateVariable(defaultValue="0", sendEvents=false)
private String clientHandshakeData = null;


/**
 * "Headless" action with ephemeral/transient state variable.
 * @param handshakeData
 */
@UpnpAction
public void setClientHandshakeData(@UpnpInputArgument(name="NewClientHandshakeDataValue")String handshakeData){
    clientHandshakeData = handshakeData;
    processCurrentHandshakeData();
    clientHandshakeData = null;

}