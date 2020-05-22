public void computeSomething(IntWritable resultA, IntWritable resultB)
{
    resultA.set(123);
    resultB.set(234);
}

// Used as
IntWritable a = new IntWritable(0);
IntWritable b = new IntWritable(0);
computeSomething(a, b);
System.out.println(a); // Prints 123
System.out.println(b); // Prints 234