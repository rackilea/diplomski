@Service
public class AuthLogic {
    private IAccountRepository accountRepository;

    @Autowired
    public AuthLogic(IAccountRepository context) {
        this.accountRepository = context;
    }
trough with the jwt token)
    public UserDetails loadUserByUsername(int userId, String username) throws UsernameNotFoundException {
        Optional<Account> foundAccount = accountRepository.findById(userId);

        Account account;
        //check if user has logged in to our inventory API before, if not create new account
        if (!foundAccount.isPresent()) {
            account = accountRepository.save(new Account(userId, username));
        } else {
            account = foundAccount.get();
        }

        return new JwtUserPrincipal(account);
    }
}