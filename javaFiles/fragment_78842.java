@Test
public void saveTest() {
    Employee expectedEmployee = buildEmployee(1, "Parker");

    //call save and flush for immediate flush.
    employeeRepository.saveAndFlush(expectedEmployee);

    //now you will need to clear the persistence context to actually
    //trigger a load from the database as employee with id 1 is already
    //in the persistence context. 

    //without the below you will not see a db select
    entityManager.clear();

    Employee actualEmployee = employeeRepository.findById(1);
    assertEquals(expectedEmployee, actualEmployee);
}