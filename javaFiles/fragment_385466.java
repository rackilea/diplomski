@JsonView(View.Default.class) 
@RequestMapping(value = "/order", method = RequestMethod.GET)  
public ResponseEntity<Order> getOrder() {
    ... 
}

@JsonView(View.Detailed.class)
@RequestMapping(value = "/order-with-items", method = RequestMethod.GET)  
public ResponseEntity<SampleResults> getOrderWithItems() {
    ... 
}