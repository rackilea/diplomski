@Embeddable
public class EmployeeId implements Serializable {

    @Column(name="EMPLOYEE_NUMBER", nullable=false, updatable=false)
    private String employeeNumber;

    @Column(name="SURVEY_NUMBER", nullable=false, updatable=false)
    private BigInteger surveyNumber;

    // getter's and setter's

    // equals and hashcode

}