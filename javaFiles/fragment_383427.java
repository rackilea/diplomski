BEGIN

   dn := 'DC=pan,DC=int';
   attrs(1) := 'maxPwdAge';

    ld := DBMS_LDAP.INIT(LDAP_SERVER, LDAP_PORT);
    ret := DBMS_LDAP.SIMPLE_BIND_S(ld, LDAP_USER, LDAP_PASSWORD);
    DBMS_LDAP.USE_EXCEPTION := FALSE;

    ret := DBMS_LDAP.SEARCH_S(
        ld => ld, 
        base => 'DC=pan,DC=int',
        SCOPE => DBMS_LDAP.SCOPE_SUBTREE,
        FILTER => '&(objectCategory=domain)(distinguishedName='||dn||')', 
        attrs => attrs,
        attronly => 0,
        res => ldapMessage);
    -- You don't need a loop because you have only one single entry and one single attribute
    ldapEntry := DBMS_LDAP.FIRST_ENTRY(ld, ldapMessage);
    attribName := DBMS_LDAP.FIRST_ATTRIBUTE(ld, ldapEntry, berEelement);
    info := DBMS_LDAP.GET_VALUES(ld, ldapEntry, attribName);    

    DBMS_OUTPUT.PUT_LINE('Password life time = ' || -info(info.FIRST)/1000/1000/10/60/60/24 || ' days');

    DBMS_LDAP.BER_FREE(berEelement, freebuf => 0);  
    ret := DBMS_LDAP.MSGFREE(ldapMessage);
    ret := DBMS_LDAP.UNBIND_S(ld);

END;