if (securityHeader == null) {
            throw new AuthenticationException("No WS-Security header found");
        }

        List<Object> securityHeaderTypes = securityHeader.getSecurityHeaderTypes();
        if (securityHeaderTypes == null || securityHeaderTypes.size() == 0) {
            throw new AuthenticationException("WS-Security header appears to be empty");
        }

        UsernameTokenType usernameToken = null;
        try {
            usernameToken = (UsernameTokenType) securityHeaderTypes.get(0);
        } catch (ClassCastException e) {
            throw new AuthenticationException("Expected UsernameToken in WS-Security header");
        }

        AttributedString usernameAttStr = usernameToken.getUsername();
        if (usernameAttStr == null) {
            throw new AuthenticationException("Expected Username in WS-Security header");
        }

        String username = usernameAttStr.getString();
        if (!username.equals(retailer.getRetailerUsername())) {
            throw new AuthenticationException("Invalid username in WS-SecurityHeader");
        }
        List<Object> any = usernameToken.getAny();
        if (any == null) {
            throw new AuthenticationException("Expected Password element in WS-Security header");
        }
        PasswordString passwordString = null;
        for (Iterator iterator = any.iterator(); iterator.hasNext();) {
            try {
                passwordString = (PasswordString) iterator.next();
            } catch (ClassCastException ignore) {
                logger.debug("Found non password string object");
            }
        }
        if (passwordString == null) {
            throw new AuthenticationException("Expected Password in WS-Security header");
        }
        if (passwordString.getAttributedString() == null) {
            throw new AuthenticationException("Expected Password AttributedString in WS-Security header");
        }

        String password = passwordString.getAttributedString().getString();
        if (!password.equals(retailer.getRetailerPassword())) {
            throw new AuthenticationException("Invalid password in WS-SecurityHeader");
        }