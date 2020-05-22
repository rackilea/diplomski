@Service
@Transactional
public class TravelService {

    private final TravelRepository travels;

    public TravelService(TravelRepository travels) {
        this.travels=travels;
    }

    public Iterable<Travel> search(Travel criteria) {

        BooleanExpression predicate = QTravel.travel...
        return travels.findAll(predicate);
    }
}