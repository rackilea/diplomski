@Stateless
public class FavoritesServiceBean implements FavoritesService 
{

    ...
    @Resource
    protected SessionContext sessionContext;

    public void addToFavorites(Question question) 
    {
        FavoritesCounter counter = getCounter(question);
        if (counter == null) {
          counter = sessionContext.getBusinessObject(FavoritesService.class)
                                  .createCounter(question);
        }
       //increase counter
    }

    @TransactionAttribute(REQUIRES_NEW)
    public FavoritesCounter createCounter(Question question) 
    {
        ...
    }
    ...
}