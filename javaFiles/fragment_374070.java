@Override
public void modifyHandshake(ServerEndpointConfig sec, 
                            HandshakeRequest request, 
                            HandshakeResponse response)
{
    sec.getUserProperties().put("TheUpgradeOrigin",request.getHeaders().get("Origin"));
    // Note: this store a List<String> in the key "TheUpgradeOrigin"
}