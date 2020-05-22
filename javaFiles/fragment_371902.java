public class EmployeeUser {
    private String userId;
    private String emailAddress;
    private String socialSecurityNumber;

    public EmployeeUser(String userId, String emailAddress, String socialSecurityNumber) {
        this.userId = userId;
        this.emailAddress = emailAddress;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public EmployeeUser(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public EmployeeUser() {}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
}