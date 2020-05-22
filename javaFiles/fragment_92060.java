Guice.createInjector(..., new ServletModule() {

   @Override
   protected void configureServlets() {
      filter("/*").through(MyFilter.class);
   }
}