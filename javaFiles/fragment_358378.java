connect("username", "password", "t3://ip:port");

edit()
startEdit()

create_AuthenticationProvider_54("/SecurityConfiguration/myDomain/Realms/myrealm", "value")
cd("/SecurityConfiguration/myDomain/Realms/myrealm")
cmo.createAuthenticationProvider("myLDAP", "weblogic.security.providers.authentication.NovellAuthenticator")

cd("/SecurityConfiguration/myDomain/Realms/myrealm/AuthenticationProviders/myLDAP")
set("GroupBaseDN", "value")
set("UserNameAttribute", "value")
set("StaticGroupObjectClass", "value")
set("UserBaseDN", "value")
set("UserObjectClass", "value")
set("AllGroupsFilter", "value")
set("Principal", "value")
set("UseRetrievedUserNameAsPrincipal", "value")
set("Host", "value")
set("StaticGroupDNsfromMemberDNFilter", "value")
set("StaticMemberDNAttribute", "value")
set("ControlFlag", "value")
set("UserFromNameFilter", "value")
set("Credential", "value")
set("GroupFromNameFilter", "value")

startEdit()
save()
activate(block="true")