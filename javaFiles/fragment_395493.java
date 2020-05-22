package com.mycompany.pima.security;

import org.springframework.security.core.AuthenticationException;

@SuppressWarnings("serial")
public final class ActiveDirectoryAuthenticationException extends AuthenticationException {
private final String dataCode;

ActiveDirectoryAuthenticationException(String dataCode, String message, Throwable cause) {
    super(message, cause);
    this.dataCode = dataCode;
}

public String getDataCode() {
    return dataCode;
}
}