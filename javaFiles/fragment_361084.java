class Person implements Comparable<Person> {
    String name;  
    int age;
    float gradeAverage;

    public int compareTo(Person other) {
        if(this.getAge() > other.getAge())
            return 1;
        else if (this.getAge() == other.getAge())
            return 0 ;
        return -1 ;
    }

    public int getAge() {
        return this.age ;
    }
}