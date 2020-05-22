@Bean
public PasswordEncoder passwordEncoder() {
    String idForEncode = "bcrypt";
    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
    Map<String, PasswordEncoder> encoderMap = 
        Collections.singletonMap(idForEncode, bcrypt);
    DelegatingPasswordEncoder delegating =
        new DelegatingPasswordEncoder(idForEncode, encoderMap);
    delegating.setDefaultPasswordEncoderForMatches(bcrypt);
    return delegating;
}