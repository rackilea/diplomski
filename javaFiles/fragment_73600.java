Test.EMPLOYEE_ID.getRealName();    // Returns "employee-id"
Test.EMPLOYEE_CODE.getRealName();  // Returns "employeeCode"

public enum Test
    EMPLOYEE_ID("employee-id"),
    EMPLOYEE_CODE("employeeCode");

    private Test(String realName) {
        this.realName = realName;
    }
    public String getRealName() {
        return realName;
    }
    private final String realName;
}