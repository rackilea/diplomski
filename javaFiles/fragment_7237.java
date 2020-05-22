@Autowired
private PaymentTransactionRepository transactionRepository;

@GetMapping
public Page<PaymentTransactionsDTO> page(@PathVariable int page, @PathVariable int size) {
    PageRequest pageRequest = PageRequest.of(page, size);
    return transactionRepository
            .findAll(pageRequest)
            .map(mapper::toDTO);
}