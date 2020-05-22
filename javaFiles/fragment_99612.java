@Validated // Add this
@RestController
public class OrderController {
    @GetMapping("order/{id}")
    public Order getCustomer(@PathVariable @ValidOrderId final Integer id) { // Add @ValidOrderId
        // Do stuff
    }
}