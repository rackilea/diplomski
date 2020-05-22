String a;
StringBuilder b;
for(int i=0; i<5; i++)
{
a += i; //String is immutable and in each iteration, a new object will be created
b.append(i); //StringBuilder is mutable and in each iteration, the existing string will be used.
}