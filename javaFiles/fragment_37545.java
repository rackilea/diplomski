@XmlRootElement(name="Department")
class Department {
    public Department() {}
    @XmlElements({
        @XmlElement(name="Manager", type=Manager.class),
        @XmlElement(name="FactoryWorker", type=FactoryWorker.class)
    })
    private Employee employee;
    public void setEmployee(Employee val) {this.employee = val;}
}