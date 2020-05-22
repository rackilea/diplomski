public class Context
{
  @Bean
  public Single single()
  {
    return new Single() {
      @Override
      Proto newInstance()
      {
        return proto();
      }
    };
  }

  @Bean
  @Scope("prototype")
  public Proto proto()
  {
    return new Proto();
  }
}