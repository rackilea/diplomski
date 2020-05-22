Class Person implements Comparable<Person>{ 
    String name;
    String gender;
    int age;

    @override
    int compareTo( Person p2 ){
        if (this.name.equals(p2.name)) return 0;
        else return Integer.compare(this.age,p2.age);
}