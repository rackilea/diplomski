public class Main {

public static void main(String[] args) {
    Person p = new Person();
    Person p2 = null;
    Address address = new Address("paseo de la reforma");
    p.setAddress(address);

    try {
         p2 = (Person) p.clonar();
    } catch (CloneNotSupportedException e) {
        e.printStackTrace();
    }   
    p2.getAddress().setStreet("lomas de chapultepec");
    System.out.println(p.getAddress().getStreet());
}
}

class Address {
private String street;

public Address(String street) {
    this.street = street;
}

public String getStreet() {
    return street;
}

public void setStreet(String street) {
    this.street = street;
}

  }

class Person implements Cloneable {
private String name;
private Integer edad;
private int mes;
private Address address;

public Integer getEdad() {
    return edad;
}

public void setEdad(Integer edad) {
    this.edad = edad;
}

public int getMes() {
    return mes;
}

public void setMes(int mes) {
    this.mes = mes;
}

public Object clonar() throws CloneNotSupportedException {
    return this.clone();
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Address getAddress() {
    return address;
}

public void setAddress(Address address) {
    this.address = address;
}
}