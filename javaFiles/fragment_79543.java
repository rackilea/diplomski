S = new empty stack data structure
for x in the input sequence:
{
    // peek instead of pop when you're checking what's in the queue
    while S is nonempty and the top element of S is greater than or equal to x:
    {
        pop S // you can call pop here
    }

    if S is empty:  // just check if the queue is empty, don't peek or pop
    {
        x has no preceding smaller value
    }
    else:
    {
        the nearest smaller value to x is the top element of S
    }
    push x onto S
}