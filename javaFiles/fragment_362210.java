public static ItemService<?> instance(Class<? extends User> c) {
    if (c == Customer.class)
        return new CustomerItemService();
    else if (c == Employee.class)
        return new EmployeeItemService();
    ...
}