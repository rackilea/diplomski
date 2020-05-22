int myNumber = 490;
int distance = Integer.MAX_VALUE;
int idx = 0;
for(int c = 0; c < numbers.length; c++)
{
    int cdistance = numbers[c] - myNumber;
    if (cdistance < distance && cdistance >= 0)
    {
        idx = c;
        distance = cdistance;
    }
}
int theNumber = numbers[idx];