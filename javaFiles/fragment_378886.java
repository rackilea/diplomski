double sum = 0;
for (int index=0; index < contestantOne.length; index++)
{
    //If you really need to remove highest and lowest value
    if (contestantOne[index] != contestantOneLow && contestantOne[index] != contestantOneHigh)
        sum += contestantOne[i];
}
double avg = sum / (double)(contestantOne.length - 2);