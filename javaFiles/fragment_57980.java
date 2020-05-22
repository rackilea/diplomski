String dn = "CN=Jimmy Blooptoop,OU=Someplace,OU=Employees,DC=Bloopsoft-Inc";
LdapName ln = new LdapName(dn);

for(Rdn rdn : ln.getRdns()) {
    if(rdn.getType().equalsIgnoreCase("CN")) {
        System.err.println("CN is: " + rdn.getValue());
        break;
    }
}