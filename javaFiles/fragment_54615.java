public class NameIsAge 
{
String userName;
int userAge;
NameIsAge (String userName, int userAge)
{
    this.userName = userName;
    this.userAge = userAge;

}
public String getUserName() {
    return userName;
}
public void setUserName(String userName) {
    this.userName = userName;
}
public int getUserAge() {
    return userAge;
}
public void setUserAge(int userAge) {
    this.userAge = userAge;
}
final void run(String[] args)
{
    System.out.println(userName + " is " + userAge);
}
}