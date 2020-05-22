// Student constructor
Student(String majorParam, String nameParam, int yobParam)
{
    super(nameParam, yobParam);
    this.major = majorParam;
}

...

// Similarly, Instructor constructor
Instructor(int salaryParam, String nameParam, int yobParam)
{
    super(nameParam, yobParam);
    salary = salaryParam;
}