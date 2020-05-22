@Component
public class Business<T extends Debit> {

    @Autowired
    @Qualifier("managerImpl2")
    private Manager<T> manager;

    public void treatment(Context<T> context, FindServiceReturnMessage response) {

        manager.manage(response, context);
    }
}