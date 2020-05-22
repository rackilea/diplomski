@Component
@Qualifier("managerImpl2")
public class ManagerImpl2 implements Manager<Debit2> {

    @Override
    public void manage(final FindServiceReturnMessage response, Context<Debit2> context) 
    {

    }
}