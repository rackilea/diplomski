@Component("appVariablesHolder")
public class AppVariablesHolder {

    @Value("${role.rolename}") 
    private String someRole;

    public String getSomeRole() {
        return this.someRole;
    }
}

@PreAuthorize("hasRole(@appVariablesHolder.getSomeRole())")
public void method() {}