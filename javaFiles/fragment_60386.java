public class Person {

    private String fullName; 
    private Boolean isSupervisor;
    private Boolean isManager;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean isSupervisor() {
        return isSupervisor;
    }

    public void setSupervisor(Boolean isSupervisor) {
        this.isSupervisor = isSupervisor;
    }

    public Boolean isManager() {
        return isManager;
    }

    public void setManager(Boolean isManager) {
        this.isManager = isManager;
    }
}