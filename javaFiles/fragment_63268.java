Object[][] result = runContext.call(new Callable<Object[][]>() {

   @Override
   public Object[][] call() throws Exception {
      return BEANS.get(IMySqlAuthService.class).load();
   }

});

//TODO implement authentication logic.