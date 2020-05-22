@XmlRootElement(name="Employess")
public class EmpList {

   private List<Emp> emps = new ArrayList<Emp>();

   public void setEmpList(List<Emp> facpList) {
      this.emps = facpList;
   }

   @XmlElement(name="Emp")
   public List<Emp> getEmpList() {
      return emps;
   }
}