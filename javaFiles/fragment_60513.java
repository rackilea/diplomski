KeyChain.choosePrivateKeyAlias(activity, new KeyChainAliasCallback() {
            public void alias(String alias) {               
                //do something with the selected alias                      
            }               
        },
        new String[] { KeyProperties.KEY_ALGORITHM_RSA, "DSA"}, // List of acceptable key types. null for any
        null,                        // issuer, null for any
        null,                        // host name of server requesting the cert, null if unavailable
        -1,                          // port of server requesting the cert, -1 if unavailable
        "");                         // alias to preselect, null if unavailable