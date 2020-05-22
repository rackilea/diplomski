DECLARE

    SUBTYPE T_USER_ACCOUNT_CONTROL IS INTEGER;
    -- see https://support.microsoft.com/en-us/help/305144/how-to-use-the-useraccountcontrol-flags-to-manipulate-user-account-pro
    SKRIPT                                  CONSTANT T_USER_ACCOUNT_CONTROL := 1;
    ACCOUNTDISABLE                          CONSTANT T_USER_ACCOUNT_CONTROL := 2;
    HOMEDIR_REQUIRED                        CONSTANT T_USER_ACCOUNT_CONTROL := 8;
    LOCKOUT                                     CONSTANT T_USER_ACCOUNT_CONTROL := 16;
    PASSWD_NOTREQD                          CONSTANT T_USER_ACCOUNT_CONTROL := 32;
    PASSWD_CANT_CHANGE                  CONSTANT T_USER_ACCOUNT_CONTROL := 64;
    ENCRYPTED_TEXT_PWD_ALLOWED          CONSTANT T_USER_ACCOUNT_CONTROL := 128;
    TEMP_DUPLICATE_ACCOUNT              CONSTANT T_USER_ACCOUNT_CONTROL := 256;
    NORMAL_ACCOUNT                          CONSTANT T_USER_ACCOUNT_CONTROL := 512;
    INTERDOMAIN_TRUST_ACCOUNT           CONSTANT T_USER_ACCOUNT_CONTROL := 2048;
    WORKSTATION_TRUST_ACCOUNT           CONSTANT T_USER_ACCOUNT_CONTROL := 4096;
    SERVER_TRUST_ACCOUNT                    CONSTANT T_USER_ACCOUNT_CONTROL := 8192;
    DONT_EXPIRE_PASSWORD                    CONSTANT T_USER_ACCOUNT_CONTROL := 65536;
    MNS_LOGON_ACCOUNT                   CONSTANT T_USER_ACCOUNT_CONTROL := 131072;
    SMARTCARD_REQUIRED                  CONSTANT T_USER_ACCOUNT_CONTROL := 262144;
    TRUSTED_FOR_DELEGATION              CONSTANT T_USER_ACCOUNT_CONTROL := 524288;
    NOT_DELEGATED                           CONSTANT T_USER_ACCOUNT_CONTROL := 1048576;
    USE_DES_KEY_ONLY                        CONSTANT T_USER_ACCOUNT_CONTROL := 2097152;
    DONT_REQ_PREAUTH                        CONSTANT T_USER_ACCOUNT_CONTROL := 4194304;
    PASSWORD_EXPIRED                        CONSTANT T_USER_ACCOUNT_CONTROL := 8388608;
    TRUSTED_TO_AUTH_FOR_DELEGATION  CONSTANT T_USER_ACCOUNT_CONTROL := 16777216;
    PARTIAL_SECRETS_ACCOUNT             CONSTANT T_USER_ACCOUNT_CONTROL := 67108864;

    LDAP_USER CONSTANT VARCHAR2(255) := 'CN=UserName1,OU=SERVICE_ACCOUNTS,OU=Users,OU=LT,OU=PB,DC=pan,DC=int';
    LDAP_PASSWORD CONSTANT VARCHAR2(30) := 'secret';
    LDAP_SERVER CONSTANT VARCHAR2(30) := 'host';
    LDAP_PORT INTEGER := 389;

    userDn VARCHAR2(100) := 'CN=UserName2,OU=SERVICE_ACCOUNTS,OU=Users,OU=LT,OU=PB,DC=pan,DC=int';


    ld DBMS_LDAP.SESSION;
    ret NUMBER; 
    ldapEntry DBMS_LDAP.MESSAGE;    
    attrs DBMS_LDAP.STRING_COLLECTION;  
    ldapMessage DBMS_LDAP.MESSAGE;
    attribName VARCHAR2(256);
    berEelement DBMS_LDAP.BER_ELEMENT;
    info DBMS_LDAP.STRING_COLLECTION;

    pwdLastSet TIMESTAMP;
    expireDate TIMESTAMP

BEGIN

    attrs(1) := 'displayName';
    attrs(2) := 'userAccountControl';
    attrs(3) := 'pwdLastSet';

    ld := DBMS_LDAP.INIT(LDAP_SERVER, LDAP_PORT);
    ret := DBMS_LDAP.SIMPLE_BIND_S(ld, LDAP_USER, LDAP_PASSWORD);
    DBMS_LDAP.USE_EXCEPTION := FALSE;

    ret := DBMS_LDAP.SEARCH_S(
        ld => ld, 
        base => 'DC=pan,DC=int',
        SCOPE => DBMS_LDAP.SCOPE_SUBTREE,
        FILTER => '&(objectCategory=user)(distinguishedName='||userDn||')', 
        attrs => attrs,
        attronly => 0,
        res => ldapMessage);
    ldapEntry := DBMS_LDAP.FIRST_ENTRY(ld, ldapMessage);
    IF ldapEntry IS NULL THEN
        DBMS_OUTPUT.PUT_LINE('User "'||userDn||'" does not exist');
    ELSE
        WHILE ldapEntry IS NOT NULL LOOP        
            attribName := DBMS_LDAP.FIRST_ATTRIBUTE(ld, ldapEntry, berEelement);
            WHILE attribName IS NOT NULL LOOP     
                info := DBMS_LDAP.GET_VALUES(ld, ldapEntry, attribName);
                CASE attribName
                WHEN 'displayName' THEN 
                    DBMS_OUTPUT.PUT_LINE('Display Name = ' || info(info.FIRST));
                WHEN 'userAccountControl' THEN
                    IF SIGN(BITAND(ACCOUNTDISABLE, info(info.FIRST))) = 1 THEN
                        DBMS_OUTPUT.PUT_LINE('Account is disabled');
                    END IF;

                    IF SIGN(BITAND(PASSWORD_EXPIRED, info(info.FIRST))) = 1 THEN
                        DBMS_OUTPUT.PUT_LINE('Password is expired');
                    END IF;                 
                WHEN 'pwdLastSet' THEN
                    pwdLastSet := (TIMESTAMP '1601-01-01 00:00:00 UTC' + info(info.FIRST)/1000/1000/10/60/60/24 * INTERVAL '1' DAY) AT LOCAL;
                    DBMS_OUTPUT.PUT_LINE('Password was changed at ' || TO_CHAR(pwdLastSet, 'yyyy-mm-dd hh24:mi:ss'));

                    -- Password life time is not available in LDAP. Check your company policy and calculate expire date accordingly, for example:
                    expireDate := pwdLastSet + INTERVAL '6' MONTH;
                    DBMS_OUTPUT.PUT_LINE('Your password will expire at ' || TO_CHAR(expireDate, 'yyyy-mm-dd hh24:mi:ss'));                  
                END CASE;       
                attribName := DBMS_LDAP.NEXT_ATTRIBUTE(ld, ldapEntry, berEelement);
            END LOOP;
            ldapEntry := DBMS_LDAP.NEXT_ENTRY(ld, ldapEntry);
        END LOOP;
        DBMS_LDAP.BER_FREE(berEelement, freebuf => 0);  
    END IF;
    ret := DBMS_LDAP.MSGFREE(ldapMessage);
    ret := DBMS_LDAP.UNBIND_S(ld);

end;