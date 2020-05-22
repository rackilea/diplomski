package com.mycompany.pima.security;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;

public class ActiveDirectoryGrantedAuthoritiesMapper implements GrantedAuthoritiesMapper {

// Constants for group defined in LDAP
// The string "ExtranetUsers" in the ROLE_ADMIN var below actually maps to the name
// of an Active Directory group.
private String ROLE_ADMIN = "ExtranetUsers";

private static final Logger logger = LoggerFactory.getLogger(ActiveDirectoryGrantedAuthoritiesMapper.class);

public ActiveDirectoryGrantedAuthoritiesMapper() {

}

@Override
public Collection<? extends GrantedAuthority> mapAuthorities(
        final Collection<? extends GrantedAuthority> authorities) {

    Set<SecurityContextAuthority> roles = EnumSet.noneOf(SecurityContextAuthority.class);

    for (GrantedAuthority authority : authorities) {

        // authority.getAuthority() returns the role in LDAP nomenclature
        if (ROLE_ADMIN.equals(authority.getAuthority())) {
            roles.add(SecurityContextAuthority.ROLE_ADMIN);
        }
    }
    return roles;
}
 }