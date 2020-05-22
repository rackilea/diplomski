auth
        .ldapAuthentication()
        .ldapAuthoritiesPopulator(new DefaultLdapAuthoritiesPopulator(contextSource, "OU=Account Groups,OU=ITS Security") {

            @Override
            public Set<GrantedAuthority> getGroupMembershipRoles(String userDn, String username) {
                Set<GrantedAuthority> groupMembershipRoles = super.getGroupMembershipRoles(userDn, username);

                boolean isMemberOfSpecificAdGroup = false;
                for (GrantedAuthority grantedAuthority : groupMembershipRoles) {

                    if ("ROLE_AD-this-is-a-specific-group".equals(grantedAuthority.toString())) {                                                       
                        isMemberOfSpecificAdGroup = true;
                        break;
                    }
                }

                if (!isMemberOfSpecificAdGroup ) {

                    throw new BadCredentialsException("User must be a member of " + "AD-this-is-a-specific-group");
                }
                return groupMembershipRoles;
            }
        })
        .userSearchFilter("(cn={0})")           
        .groupSearchBase("OU=Account Groups,OU=ITS Security")
        .groupSearchFilter("(member={0})") 
        .contextSource(contextSource);