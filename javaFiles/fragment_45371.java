@Autowired
                    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
                    }


            @Bean
                public PasswordEncoder passwordEncoder(){
                    PasswordEncoder encoder = new FlasherPasswordEncoder();
                    return encoder;
                }