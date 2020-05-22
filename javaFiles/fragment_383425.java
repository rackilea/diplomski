DECLARE

    ret NUMBER;     
    ld DBMS_LDAP.SESSION;
    SUCCESS INTEGER;

    ldap_host VARCHAR2(100) := 'host';
    ldap_port INTEGER := 389;

    userDn VARCHAR2(100) := 'OU=SERVICE_ACCOUNTS,OU=Users,OU=LT,OU=PB,DC=pan,DC=int';
    userPassword VARCHAR2(100) := 'secret';

BEGIN
    DBMS_LDAP.USE_EXCEPTION := TRUE;
    ld := DBMS_LDAP.INIT(ldap_host, ldap_port);
    DBMS_LDAP.USE_EXCEPTION := FALSE;

    SUCCESS := DBMS_LDAP.SIMPLE_BIND_S(ld, userDn, userPassword);
    IF SUCCESS = DBMS_LDAP.SUCCESS AND userPassword IS NOT NULL THEN
        DBMS_OUTPUT.PUT_LINE('Password is valid');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Wrong password');
    END IF;

    ret := DBMS_LDAP.UNBIND_S(ld);

END;