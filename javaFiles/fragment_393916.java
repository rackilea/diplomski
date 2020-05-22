Case 1 : Employee as Owner

@Entity
Public class Employee
{
  @ManyToOne
  private Company company;
 ......
}

@Entity
Public class Company
{
  @OneToMany(mappedBy="company") \\ mappedBy is used to say that Employee is owner and 
                               \\it should match variable name company
  private List<Employee> employee;
  ......
}