private ObjectMapper mapper = new ObjectMapper();

@RequestMapping(value="/employees12/{id}", method=RequestMethod.GET)
public Employee getPerson(@PathVariable Long id){
    Employee employee = employeeRepository.findOne(id);
    System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee));
    return employee;
}