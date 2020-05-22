public class Company {

    private Integer connectTimeout;
    private Integer socketTimeout;
    private Integer clientTimeout;
    private Department library;
    private Department admin;
    private Department transport;
    private Department finance;

    public void setDept1(Department dept1) {
        this.library = dept1;
    }

    public void setDept2(Department dept2) {
        this.admin = dept2;
    }

    public void setDept3(Department dept3) {
        this.transport = dept3;
    }

    public void setDept4(Department dept4) {
        this.finance = dept4;
    }

    // other getter/setters

    public static class Department {

        private Integer connectTimeout;
        private Integer socketTimeout;
        private Integer clientTimeout;

        // getter/setters
    }
}