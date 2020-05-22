@Component
public class SecUserDetailsService implements ReactiveUserDetailsService {

    @Autowired
    public ReactiveUserAccountRepository reactiveUserAccountRepository;


    @Override
    public Mono<UserDetails> findByUsername(String username) {
        Mono<UserAccount> data = reactiveUserAccountRepository.findByUsername(username);
        return data.cast(UserDetails.class);
    }
}