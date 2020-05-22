mag_max = magnitude[0];
i_max = 0;
for (i = 1; i < N; ++i)
{
    if (magnitude[i] > mag_max)
    {
        mag_max = magnitude[i];
        i_max = i;
    }
}