@Override
public void configure(WebSecurity web) throws Exception {
    web.ignoring()
       .antMatchers(
               // Vaadin Flow static resources
               "/VAADIN/static/**",

               //Rest of configuration omitted for simplicity
}