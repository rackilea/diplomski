{
  "jcr:primaryType": "nt:folder",
  "config": {
    "jcr:primaryType": "sling:Folder",
    "org.apache.jackrabbit.oak.security.authentication.ldap.impl.LdapIdentityProvider-test": {
      "jcr:primaryType": "sling:OsgiConfig",
      "provider.name": "ldap-test-alex",
      "host.name": "localhost",
      "host.port": "10389",
      "host.ssl": false,
      "host.tls": false,
      "bind.dn": "uid=admin,ou=system",
      "bind.password": "secret",
      "user.objectclass": "person",
      "user.baseDN": "ou=people,o=sevenSeas",
      "user.idAttribute": "uid",
      "group.objectclass": "groupOfUniqueNames",
      "group.baseDN": "ou=groups,o=sevenSeas",
      "group.nameAttribute": "cn",
      "group.memberAttribute": "uniquemember",
    },
    "org.apache.jackrabbit.oak.spi.security.authentication.external.impl.DefaultSyncHandler-test": {
      "jcr:primaryType": "sling:OsgiConfig",
      "handler.name": "ldap-sync-test-alex",
      "user.pathPrefix": "ldap-test",
      "group.pathPrefix": "ldap-test",
      "user.membershipNestingDepth": 1,
      "user.autoMembership": [
        "contributor"
      ],
      "user.propertyMapping": [
        "profile/email=mail",
        "profile/familyName=sn",
        "profile/givenName=givenName",
        "profile/aboutMe=description"
      ]
    },
    "org.apache.jackrabbit.oak.spi.security.authentication.external.impl.ExternalLoginModuleFactory-test": {
      "jcr:primaryType": "sling:OsgiConfig",
      "idp.name": "ldap-test-alex",
      "sync.handlerName": "ldap-sync-test-alex",
      "jaas.controlFlag": "SUFFICIENT",
      "jaas.ranking": "50"
    }
  }
}