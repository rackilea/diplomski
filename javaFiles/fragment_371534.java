@Service
public class DetailsProviderLocator {

    private DetailsProvider dogDetailsProvider;
    private DetailsProvider catDetailsProvider;
    private DetailsProvider elephantDetailsProvider;

    @Autowired
    public DetailsProviderLocator(
            @Qualifier("DogDetailsProvider") DetailsProvider dogDetailsProvider, 
            @Qualifier("CatDetailsProvider") DetailsProvider catDetailsProvider, 
            @Qualifier("ElephantDetailsProvider") DetailsProvider elephantDetailsProvider) {
        this.dogDetailsProvider = dogDetailsProvider;
        this.catDetailsProvider = catDetailsProvider;
        this.elephantDetailsProvider = elephantDetailsProvider;
    }

    DetailsProvider getDetailsProvider(Animal animal) {
        switch(animal) {
            case CAT        : return catDetailsProvider;
            case DOG        : return dogDetailsProvider;
            case ELEPHANT   : return elephantDetailsProvider;
            default         : throw new IllegalArgumentException("Not allowed!");
        }
    }

}

public enum Animal {

    CAT, DOG, ELEPHANT;

}