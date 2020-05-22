@Entity
class Enterprise
{
   @OneToMany(mapped-by="enterprise")
   public List<Employee> getEmployers()
   // implementation    

   @OneToOne
   public Employee getPresident()
   // implementation
}

@Entity
class Employee 
{
   @ManyToOne
   @JoinTable ( name="Enterprise", joinColumns={ @JoinColumn(name="ENT_ID", referencedColumnName="ENT_ID") }
   public Enterprise getEnterprise()
   // implementation
}