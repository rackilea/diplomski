public Person(String firstName, String lastName) {
    this.privateSetFirstName(firstName);
    this.privateSetLastName(lastName);
}
private void privateSetFirstName(String firstName) {
    // ...your logic for setting the field...
}
private void privateSetLastName(String lastName) {
    // ...your logic for setting the field...
}
public void setFirstName(String firstName) {
    this.privateSetFirstName(firstName);
}
public void setLastName(String lastName) {
    this.privateSetLastName(lastName);
}