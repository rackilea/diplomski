public class SpringCompleteAutoloadTilesInitializer extends    CompleteAutoloadTilesInitializer
{
    @Override
    protected AbstractTilesContainerFactory   createContainerFactory(ApplicationContext context)
    {
        return new SpringCompleteAutoloadTilesContainerFactory();
    }
}