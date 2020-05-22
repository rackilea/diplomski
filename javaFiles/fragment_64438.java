@RequestMapping(method = RequestMethod.GET)
public String showOrders() {
    //no need to manually modify currentStatus in the model anymore
    return "admin/orders";
}

@ModelAttribute("currentStatus")
public Order.Status populateCurrentStatus(@RequestParam(value = "status", defaultValue = "PAYMENT") String status) {    
    return Order.Status.valueOf(status);
}

@ModelAttribute("orders")
public List<Order> populateOrders(@ModelAttribute("currentStatus") Order.Status status) {
    return orderBo.getByStatus(status);
}