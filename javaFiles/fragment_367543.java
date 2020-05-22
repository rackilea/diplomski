@Override
public void configure(WebSecurity web) throws Exception {
    web.ignoring()
       .antMatchers(
               // Vaadin Flow static resources
               "/VAADIN/**", // This was the problematic spot

               //Rest of configuration omitted for simplicity
}