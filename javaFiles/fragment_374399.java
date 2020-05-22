@Component
public class RecommendationEngine {

    @Autowired
    private FundRepository fundRepo;

    //Method that invokes method from fundRepo but causes null pointer because fundRepo is null
}