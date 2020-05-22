class Student {
    String name;
    int age;
    public Student(String name, int age) {
       this.name = name;
       this.age = age;
    }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String toString() {
        return "Name: " + getName() + " Age: " + getAge());
    }
}