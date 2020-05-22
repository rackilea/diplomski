// Skip initial items that are < pivot
int iInsert = 0;
while (iInsert < a.Length && a[iInsert] < pivot)
{
    ++iInsert;
}
// Skip items that are = pivot
int numPivot = 0;
while (iInsert < a.Length && a[iInsert] == pivot)
{
    ++iInsert;
    ++numPivot;
}

int iCurrent = iInsert;
// Items will be added AFTER iInsert.
// Note that iInsert can be -1.
--iInsert;
while (iCurrent < a.Length)
{
    if (a[iCurrent] < pivot)
    {
        if (numPivot == 0)
        {
            ++iInsert;
            int temp = a[iInsert];
            a[iInsert] = a[iCurrent];
            a[iCurrent] = temp;
        }
        else
        {
            ++iInsert;
            int temp = a[iInsert];
            a[iInsert - numPivot] = a[iCurrent];
            a[iCurrent] = temp;
            a[iInsert] = pivot;
        }
    }
    else if (a[iCurrent] == pivot)
    {
        ++iInsert;
        int temp = a[iInsert];
        a[iInsert] = pivot;
        a[iCurrent] = temp;
        ++numPivot;
    }
    ++iCurrent;
}

int firstPivot = iInsert - numPivot + 1;