@Service
public class OrderRangeService {

    @Autowired
    OrderRangeRepository orderRangeRepository ;

    public List<OrderEntity> findAmountsBetween(int startAmt, int endAmt) {
        List<OrderEntity> amountsBetween = orderRangeRepository.findByAmountBetween(startAmt, endAmt);
        return amountsBetween;
    }

}