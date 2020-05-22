public static boolean authenticateLDAPUser(String strUser, String strPass, String strDomain, String strHost) throws NamingException, Exception {
        LDAPAuthentication ldap = new LDAPAuthentication();
        Attributes att = ldap.authenticateUser(strUser, strPass, strDomain, strHost, "");
        if (att != null) {
            try {
                ETT_UserDTL tmpUser = (ETT_UserDTL) DataUtil.performAction(DATA_UserGUI.class, "getInfByUserName", strUser);
                tmpUser.setPassword(strPass);
                if (!otherAuthenticate(tmpUser)) {
                    Authenticator.removeUser();
                    return false;
                } else {
                    ;
                }
                pushUser(tmpUser);
                return true;
            } catch (TelsoftException ex) {
                SystemLogger.getLogger().error(ex);
                return false;
            }
        } else {
            updateLoginFail();
            return false;
        }
    }