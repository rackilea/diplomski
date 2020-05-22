public final class MyJerseyModule extends JerseyServletModule
{
   @Override
   protected void configureServlets()
   {
      ...
      filter("/*").through(GuiceContainer.class);
      bind(MyExceptionMapper.class);
      ...
   }
}