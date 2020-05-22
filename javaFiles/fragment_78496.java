public class EmployeeBean implements Serializable {

  private static final long serialVersionUID = 1L;

  private Map<String, Object> employee;

  public Map<String, Object> getEmployee() {
    if (employee == null) {
        employee = new HashMap<String, Object>();
    }

    return employee;
  }

  public boolean isStaffMember() {
        return "Yes".equals(getEmployee().get("staffMember"));
  }

}