public class Person implements Comparable {
    private String name;
    private int id;
    private int age;
    private int gpa;

    public Person(String name, int id, int age, int gpa) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.gpa = gpa;
    }
    //getters and setters here...

    //logic for the comparison
    //NOTE: you can improve the comparison algorithm.
    public int compareTo (Person p) {
        //0 means both Person objects are equal.
        // > 0 means **this** object is greater than p object.
        // < 0 means **this** object is less than p object.
        int result = 0;
        //comparison by id
        if (this.id > p.id) {
            result = 1;
        } else {
            if (this.id < p.id) {
                result = -1;
            } else { //same id, check by age
                if (this.age > p.age) {
                    result = 1;
                } else {
                    if (this.age < p.age) {
                        result = -1;
                    } else { //same id and age, check by gpa
                        if (this.gpa > p.gpa) {
                            result = 1;
                        } else {
                            if (this.gpa < p.gpa) {
                                result = -1;
                            }
                        }
                    }
                }
            }
        }
    }
    return result;
}