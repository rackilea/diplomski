element x;
int count ← 0;
For(i = 0 to n − 1)
{
    if(count == 0) { x ← A[i]; count ++; }
    else if (A[i] == x) count ++;
    else count −−
}
Check if x is dominant element by scanning array A.