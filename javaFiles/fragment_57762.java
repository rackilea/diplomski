@Test
public void verify_logging() throws Exception {
    Log log = mock(Log.class);

    Employee emp = new Employee();

    saveEmployee(emp);

    verify(log, times(1)).error("Error occured");
}