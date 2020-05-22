@Component 
public class ApplicationStartUp implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private AccountRepository accountRepository;

    @SuppressWarnings("null") 
    @Override 
    public void onApplicationEvent(final ApplicationReadyEvent event) { 
        Account account = new Account("sPatel", "Spring", true); 

        accountRepository.save(account); 
        return; 
    }

}