Map<Class<? extends User>, Class<? extends ItemService>> services = 
    new HashMap<Class<? extends User>, Class<? extends ItemService>>() {{
    put(Customer.class, CustomerItemService.class);
    put(Employee.class, EmployeeItemService.class);
    // more...
}};