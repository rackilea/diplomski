@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user=userservice.getUserByusername(username);

            if(user != null && user.isEnabled()) {//here you can check that
                List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
                return buildUserForAuthentication(user, authorities);
            } 

            else {
                throw new UsernameNotFoundException("username not found");
            }

    }