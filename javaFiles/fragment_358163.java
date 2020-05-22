private String addColon(String openOrclose)
{
    String newHour = null;
    if(openOrclose.length() == 3)
    {
        newHour = openOrclose.substring(0,1) + ":" + openOrclose.substring(1,3);

    }
    else
    {
        newHour = openOrclose.substring(0,2) + ":" + openOrclose.substring(2,4);
    }
    return newHour;
}