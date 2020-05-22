<security:ldap-authentication-provider
        group-search-filter="member={0}"
        group-search-base="ou=groups"
        user-search-base="ou=people"
        user-search-filter="uid={0}"
    />