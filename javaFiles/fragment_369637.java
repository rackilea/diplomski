import com.google.inject.AbstractModule;

public class MyModule extends AbstractModule
{
   @Override
   protected void configure()
   {
      ...
      bind(MyExceptionMapper.class);
      ...
   }
}