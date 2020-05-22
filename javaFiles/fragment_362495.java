public class Details {
     private String lastname;
     private String nickname;
     private int salary;

@XmlElement
public String getLastname() {
   return lastname;
}
public void setLastname(String lastname) {
    this.lastname = lastname;
}

 @XmlElement
 public String getNickname() {
     return nickname;
 }
 public void setNickname(String nickname) {
    this.nickname = nickname;
 }

 @XmlElement
 public int getSalary() {
    return salary;
}
public void setSalary(int salary) {
    this.salary = salary;
}
}