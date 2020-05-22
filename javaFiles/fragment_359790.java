for (int i = 2; i < input; i++)
{
    fib[i] = fib[i - 1] + fib[i - 2];
    fib2[i] = fib2[i - 1] + fib2[i - 2];
}

for (int i = 2; i < input; i++)
{
    fib[i] = separate(fib[i]);
    fib2[i] = separate2(fib2[i]);
}