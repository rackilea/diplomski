public class Monster {
   String name = null;
   String location = null;
   int age = 0;

public Monster(String name, String loc, int age) { 
   this.name = name;
   this.loc = location;
   this.age = age;
 }

public void printDetails() {
   System.out.println(name + " is from " + location +
                                     " and is " + age + " old.");
 }
}