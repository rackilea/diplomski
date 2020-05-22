@Component
public class ManagerImpl2Business<Debit2> {

    @Autowired
    @Qualifier("managerImpl2")
    private Manager<Debit2> manager;

    public void treatment(Context<Debit2> context, FindServiceReturnMessage response) {

        manager.manage(response, context);
    }
}