abstract class Person {
    ...
    public abstract Person deepCopy();
}

class Student {
    ...
    public Student deepCopy() {
        return new Student(this);
    }
}

class Teacher {
    ...
    public Teacher deepCopy() {
        return new Teacher(this);
    }
}