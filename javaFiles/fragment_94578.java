import java.security.*;
import java.util.*;

import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.ldap.*;

...

private Hashtable                       masterEnv;          // master environment settings
private String                          authMethod;         // default authentication method

...

public void init() {
    // NOTE: Important to use a non-pooled context and a clone of the environment so that this authenticated
    //       connection is not returned to the pool and used for other operations
    masterEnv=new Hashtable();
    masterEnv.put(Context.INITIAL_CONTEXT_FACTORY,ldapFactory);
    masterEnv.put(Context.PROVIDER_URL,providerUrl);
    masterEnv.put(Context.SECURITY_PROTOCOL,secProtocol);
    masterEnv.put(Context.REFERRAL,"follow");
    masterEnv.put("com.sun.jndi.ldap.connect.pool","false");

    authMethod=System.getProperty("authenticationMethod","simple");
    }

...

private void verifyUserPassword(String ui, String pw, String am) throws NameNotFoundException, AuthenticationException, AuthenticationNotSupportedException, NamingException, NamingException {
    // ui=user ID
    // pw=password
    // am=authentication method

    DirContext      lc=null;                                // ldap context object
    Hashtable       le;                                     // ldap environment object

    if(am.length()==0) { am=authMethod; }

    le=(Hashtable)masterEnv.clone();
    le.put(Context.SECURITY_AUTHENTICATION,am);
    le.put(Context.SECURITY_PRINCIPAL     ,ui);
    le.put(Context.SECURITY_CREDENTIALS   ,pw);
    lc=new InitialDirContext(le);
    lc.close();
    }