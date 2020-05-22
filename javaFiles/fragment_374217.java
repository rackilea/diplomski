.and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), tokenDAO))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), tokenDAO))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Autowired
    TokenDAOImpl tokenDAO;