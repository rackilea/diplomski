@XmlType(name = "person", propOrder = {"name", "age", "nickName" , "saldo"})
public class Person {

private String name;
private Integer age;
private String nickName;
private Integer id;
private Double saldo;

public Person(String name, Integer age, String nickName, Integer id, Double saldo) {
  this.name = name;
  this.age = age;
  this.nickName = nickName;
  this.id = id;
  this.saldo = saldo;
}

public Person() {
  //jaxb constructor
}

@XmlElement(defaultValue="0")
public Integer getAge() {
  return age;
}

@XmlTransient
public Integer getId() {
  return id;
}

@XmlElement(defaultValue="")
public String getName() {
  return name;
}

@XmlElement(name="nickname" , defaultValue="")
public String getNickName() {
 return nickName;
}

@XmlElement(defaultValue="0")
public Double getSaldo() {
  return saldo;
}

public void setAge(Integer age) {
  this.age = age;
}

public void setId(Integer id) {
  this.id = id;
}

public void setName(String name) {
  this.name = name;
}

public void setNickName(String nickName) {
  this.nickName = nickName;
}

public void setSaldo(Double saldo) {
  this.saldo = saldo;
}


}