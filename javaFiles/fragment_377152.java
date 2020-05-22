class MyClass {
    int information;
    static int usefulNumber = 72;

    int method() {
        return information;
    }

    static int methodStatic() {
        // Cannot refer to information
        // But can refer to usefulNumber
    }
}