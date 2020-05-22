public void addExp(int num)
{
    EXP += num;

    if (EXP == NextGoaltoLvl)
    {
        addLevel(1); NextGoaltoLvl += 1000; EXP = 0; 
    }
}