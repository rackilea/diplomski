public Student(String name) {
    this.name = name;
    this.accountNumber = lastAssignedNumber;
    lastAssignedNumber++;
    setloginId(); //need to call this
}