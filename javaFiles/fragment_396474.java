@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private final PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> insert(@RequestBody Payment payment) {
        paymentRepository.save(payment);
        return ResponseEntity.accepted().build();

    }
}