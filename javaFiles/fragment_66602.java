public Array sort()
{
    if(a.length < 2)
        return this;

    int half = a.length / 2;
    Array left = slice(0, half).sort();
    Array right = slice(half, a.length).sort();
    return merge(left, right);
}