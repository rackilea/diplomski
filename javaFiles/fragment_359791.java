for (int i = 2; i < input; i++)
    fib[i] = fib[i - 1] + fib[i - 2];

for (int i = 2; i < input; i++)
{
    fib2[i] = separate2(fib[i]);
    fib[i] = separate(fib[i]);
}