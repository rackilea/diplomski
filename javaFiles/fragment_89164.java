@NamedNativeQuery(
    name="callRegistrationProcedure",
    query="call GETREGISTRATIONRECORDS(?,:regID)",
    callable=true,
    resultClass=Registration.class)
@Entity
public class Registration { 
......
}