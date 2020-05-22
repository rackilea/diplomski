// client credentials handle
IWindowsCredentialsHandle credentials= WindowsCredentialsHandleImpl.getCurrent("Negotiate");
credentials.initialize();

// initial client security context
WindowsSecurityContextImpl clientContext = new WindowsSecurityContextImpl();
clientContext.setPrincipalName(Advapi32Util.getUserName());
clientContext.setCredentialsHandle(credentials.getHandle());
clientContext.setSecurityPackage(securityPackage);
clientContext.initialize();

// accept on the server
WindowsAuthProviderImpl provider = new WindowsAuthProviderImpl();
IWindowsSecurityContext serverContext = null;

do {  

    if (serverContext != null) {

        // initialize on the client
        SecBufferDesc continueToken = new SecBufferDesc(Sspi.SECBUFFER_TOKEN, serverContext.getToken());
        clientContext.initialize(clientContext.getHandle(), continueToken);
    }  

    // accept the token on the server
    serverContext = provider.acceptSecurityToken(clientContext.getToken(), "Negotiate");

} while (clientContext.getContinue() || serverContext.getContinue());

System.out.println(serverContext.getIdentity().getFqn());
for (IWindowsAccount group : serverContext.getIdentity().getGroups())
    System.out.println(" " + group.getFqn());