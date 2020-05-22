package com.mycompany.pima.security;

import org.springframework.security.core.GrantedAuthority;

public enum SecurityContextAuthority implements GrantedAuthority {

// These roles are specified in the security context (security.xml) and are
// mapped to LDAP roles by the ActiveDirectoryGrantedAuthoritiesMapper
ROLE_ADMIN;

@Override
public String getAuthority() {
    return name();
}   
}