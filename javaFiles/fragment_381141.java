import com.google.gson.annotations.SerializedName;

public class EmployeeDto {
    @SerializedName("employee")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public class Employee {
        @SerializedName("id")
        private String id;
        @SerializedName("password")
        private String password;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}