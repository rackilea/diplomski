public class Staff 
{
    String firstname= "";
    String  lastname ="";
    String nickname = "";
    String salary = "";

    public Staff(String firstname,String lastname,String nickname,String salary)
    {
         this.firstname= firstname;
         this.lastname =lastname;
         this.nickname = nickname;
         this.salary = salary;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }

}