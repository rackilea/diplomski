package org.jboss.test;

import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class EmptyLoginModule implements LoginModule {

  public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
      Map<String, ?> options) {
  }

  public boolean login() throws LoginException {
    return true;
  }

  public boolean commit() throws LoginException {
    System.out.println("Authenticated");
    return true;
  }

  public boolean abort() throws LoginException {
    return true;
  }

  public boolean logout() throws LoginException {
    return true;
  }

}