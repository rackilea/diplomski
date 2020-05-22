@Component
public class OrderIdValidator implements ConstraintValidator<ValidOrderId, Integer> {
    private OrderRepository repository;

    public OrderIdValidator(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        return repository.existsById(id);
    }
}