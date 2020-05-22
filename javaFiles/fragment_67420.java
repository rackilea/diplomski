public class Student{
private int id;
private String Name;
private String biography;

public Student(int id, String name, String biography) {
    super();
    this.id = id;
    Name = name;
    this.biography = biography;
}
public int getId() {
    return id;
}       
public String getBiography() {
    return biography;
}
public void setBiography(String biography) {
    this.biography = biography;
}
@Override
public String toString() {
    return "Student [id=" + id + ", Name=" + Name + ", biography=" + biography + "]";
}       
}