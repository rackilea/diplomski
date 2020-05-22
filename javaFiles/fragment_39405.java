public void orderServed(Long employeeId, Long orderId)  {
    Orders order = orderRepository.findOne(orderId);
    Employee employee = employeeRepository.findOne(employeeId);

    //Set the forign key
    order.setServedBy(employee);

    employeeRepository.save(employee);
}