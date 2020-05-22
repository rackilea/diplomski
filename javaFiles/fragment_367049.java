public Person(String name, String phone) {
    this.name = name;
    phone = phone.replaceAll("\\W+", "");
    phone = "+1"+phone;
    this.phone = phone;
}

@Override
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o == null || getClass() != o.getClass())
        return false;
    Person person = (Person) o;
    return name != null ? name.equals(person.name) : person.name == null && (phone != null ? phone.equals(person.phone) : person.phone == null);

}

@Override
public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (phone != null ? phone.hashCode() : 0);
    return result;
}