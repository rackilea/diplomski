@Entity
class Employee {
  @Id
  private Long id;
  @OneToOne
  private EmployeeLang employeeLang;
  ...
}
@Entity
class EmployeeLang {
  @Id
  private Long id;
  private String langCode;
  @OneToOne
  private Employee employee;
  ...
}