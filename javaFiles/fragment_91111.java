List<Authority> auths = new ArrayList<Authority>();

Authority auth = new WritePermission();

auths.add(auth);

user.setAuthorities(auths);