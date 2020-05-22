private int age;

@Option(name = "age")
void setAge(int age) {
    if (age < 1) {
        throw new CmdLineException("message");
    }
    this.age = age;
}