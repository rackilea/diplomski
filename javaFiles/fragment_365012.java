cas.authn.spnego.kerberosConf=/etc/cas/config/krb5.conf
cas.authn.spnego.jcifsServicePrincipal=service_xxx@domain.com
cas.authn.spnego.loginConf=file:/etc/cas/config/login.conf
cas.authn.spnego.kerberosRealm=DOMAIN.COM

cas.authn.spnego.principal.principalAttribute=sAMAccountName

cas.authn.spnego.ldap.ldapUrl=ldap://path.to.ldap.domain.com 
cas.authn.spnego.ldap.baseDn=DC=domain,DC=com #this is base dn where LDAP starts searching for users
cas.authn.spnego.ldap.bindDn=cn=SERVICE_XXX,DC=domain,DC=com #it's a kind of login to LDAP
cas.authn.spnego.ldap.failFast=false
cas.authn.spnego.ldap.subtreeSearch=true
cas.authn.spnego.ldap.useSsl=false
cas.authn.spnego.ldap.searchFilter=cn={host}