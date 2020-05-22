public void addExp(int num)
{
    EXP += num;
}
while (true)
{   
    if (EXP == NextGoaltoLvl)
    {
        addLevel(1); NextGoaltoLvl += 1000; EXP = 0; 
    }
}