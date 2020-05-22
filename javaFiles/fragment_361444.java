public class RegistrationRequest {
    String firstName;
    String lastName;
    String department;
    String userName;
    String userPassword;
    String confirmPassword;
    String email;
    String contactNo;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContactNo() {
        return contactNo;
    }
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    public RegistrationRequest(String firstName, String lastName, String department, String userName, String userPassword, String confirmPassword, String email, String contactNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.userName = userName;
        this.userPassword = userPassword;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.contactNo = contactNo;
    }
    public RegistrationRequest() {
    }

}