public class MyAuthenticationPlugin extends SimpleAuthenticationPlugin {
            private String  username ="username";
            private String  password ="password";
            private String  groups = "groups";

            Map<String, String> userPasswords = new HashMap<String, String>();
            List<AuthenticationUser> authenticationUserList = new ArrayList();

            public MyAuthenticationPlugin(){
                secureME();
            }
            public void secureME(){
                userPasswords.put(username, password);
                authenticationUserList.add(new AuthenticationUser(username,password, groups));
                this.setUserPasswords(userPasswords);
                this.setUsers(authenticationUserList);
            }
   }