@Override
public boolean equals(Object o) {
    if(!(o instanceof Person))
        return false;
    Person num1 = (Person) o;
    if ((this.name.equals(num1.name))&&(this.address.equals(num1.address))&&
            (this.age==num1.age)&&(this.phoneNumber==num1.phoneNumber))
        return true;
}