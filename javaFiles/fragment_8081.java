@MappedSuperclass
    public class Employee {
        @Id protected Integer id;
        @Version protected Integer version;
        protected String address;
        public Integer getId() { ... }
        public void setId(Integer id) { ... }
        public String getAddress() { ... }
        public void setAddress(String address) { ... }
    }

    @Entity
    @AttributeOverride(name="address", column=@Column(name="ADDR"))
    public class PartTimeEmployee extends Employee {
        // address field mapping overridden to ADDR
        protected Float wage();
        public Float getHourlyWage() { ... }
        public void setHourlyWage(Float wage) { ... }
    }