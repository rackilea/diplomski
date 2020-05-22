@Bean
public PasswordEncoder passwordEncoder() {
    String idForEncode = "bcrypt";
    PasswordEncoder existing = new MyPasswordEncoder();
    PasswordEncoder updated = new BCryptPasswordEncoder();
    Map<String, PasswordEncoder> encoderMap = 
        Collections.singletonMap(idForEncode, updated);
    DelegatingPasswordEncoder delegating =
        new DelegatingPasswordEncoder(idForEncode, encoderMap);
    delegating.setDefaultPasswordEncoderForMatches(existing);
    return delegating;
}