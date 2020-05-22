public class Student implements java.io.Serializable{
 private String name;
 private Integer id;
 public Student(){}

 public void setName(String name){
  this.name=name;
 }
 public String getName(){
  return this.name;
 }
 public void setId(Integer id){
  this.id=id;
 }
public Integer getId(){
 return this.id;
 }
}