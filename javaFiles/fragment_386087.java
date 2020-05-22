public class Persons {

int id;//persons id
String name;//persons name
String email;//persons email

public Persons(int idNum, String student, String eAddress){
    this.id = idNum;
    this.name = student;
    this.email = eAddress;
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/**
 * Id number
 * @return  integer of the id
 */
public int getId(){
    return id;
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/**
 * name of person
 * @return  string of the name
 */
public String getName(){
    return name;
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/**
 * Email address for person
 * @return string of the email
 */
public String getEmail(){
    return email;
} 
}