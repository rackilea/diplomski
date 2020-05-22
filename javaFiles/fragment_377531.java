@Embeddable
public class EmployeeId implements Serializable {

    @Column(name="EMPLOYEE_NUMBER")
    private String employeeNumber;

    @Column(name="SURVEY_NUMBER")
    private BigInteger surveyNumber;

    // getter's and setter's

    // equals and hashcode

}