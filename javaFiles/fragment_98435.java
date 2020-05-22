env.put(Context.SECURITY_AUTHENTICATION, "simple");
env.put(Context.SECURITY_PRINCIPAL, domainName + "\\" + username);
env.put(Context.SECURITY_CREDENTIALS, password);

try{
    return new InitialLdapContext(env, null);
}
catch(javax.naming.CommunicationException e){
    throw new NamingException("Failed to connect to " + domainName + ((serverName==null)? "" : " through " + serverName));
}
catch(NamingException e){
    throw new NamingException("Failed to authenticate " + username + "@" + domainName + ((serverName==null)? "" : " through " + serverName));
}