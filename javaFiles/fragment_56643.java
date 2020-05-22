public class Employee {

private String firstname;
private String lastname;
@Transient
@JsonProperty("company_id")
private Long companyId;