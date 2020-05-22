public void computeSomething(int resultA, int resultB)
{
    resultA = 123;
    resultB = 234;
}

// Used as
int a = 0;
int b = 0;
computeSomething(a, b);
System.out.println(a); // Prints 0
System.out.println(b); // Prints 0