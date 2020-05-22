int freq = 0;
int value = 0;
int length = MMMArray.length;

for (int outer = 0; outer < length; outer++)
{
    int tempFreq = 0;

    for (int inner = 0; inner < length; inner++)
    {
        if (MMMArray[outer] == MMMArray[inner])
        {
            tempFreq++;
        }
    }

    if (tempFreq > freq)
    {
        freq = tempFreq;
        value = MMMArray[outer];
    }
}

System.out.println("Mode is " + value + ", which appears " + freq + " times.");