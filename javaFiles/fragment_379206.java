public int sneakyNewYears(int year)
{
    int diff = year % 4;

    int add = -1;
    if(diff == 0) add = 5;
    if(diff == 1) add = 6;
    if(diff == 2) add = 6;
    if(diff == 3) add = 11;

    return year + add;
}