Credentials cred = new UsernamePasswordCredentials("user", "pswd");


         httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT, AuthScope.ANY_REALM),
                    cred);