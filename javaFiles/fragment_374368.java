PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

     @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {

            auth
                    .inMemoryAuthentication()
                    .withUser("test")
                    .password(passwordEncoder.encode("test123"))
                    .roles("USER","ADMIN","MANAGER")
                    .authorities("CAN_READ","CAN_WRITE","CAN_DELETE");
        }