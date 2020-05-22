public String addBonus(double[] empBonus)
{
    StringBuilder arrayBonus = new StringBuilder();

    for(int i=0; i<empBonus.length;i++)
    {
        arrayBonus.append(empBonus[i] + ", ");
    }

    return arrayBonus.toString();
}