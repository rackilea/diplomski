public class User {

     public User(String username, String password) {
          this.username = username;
          this.password = password;
     }

     public String getClientno() {
          return clientno;
     }

     public void setClientno(String clientno) {
          this.clientno = clientno;
     }

     public String getCompanyno() {
          return companyno;
     }

     public void setCompanyno(String companyno) {
          this.companyno = companyno;
     }

     public String getUserno() {
          return userno;
     }

     public void setUserno(String userno) {
          this.userno = userno;
     }

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public int getRowno() {
          return rowno;
     }

     public void setRowno(int rowno) {
          this.rowno = rowno;
     }

     String clientno;
     String companyno;
     String userno;
     String username;
     String password;
     int rowno;
}