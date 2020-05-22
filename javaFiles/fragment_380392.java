public class PetitionContext {
    ... just a POJO, getters and setters etc. 
}

@Service
public class PetitionScopedService {

    private ThreadLocal<PetitionContext> = new ThreadLocal<PetitionContext>();


    public doSomethingPetitionSpecific() {
        ... uses the petition context ...
    }
}

@Service
public class SomeOtherService {

    @Autowired
    private PetitionScopedService petitionService;

    ... use petition service that is a singleton with thread scoped internal state, effectivelly thread scoped ...
}