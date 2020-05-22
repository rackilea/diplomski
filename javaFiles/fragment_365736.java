public String generateNumber()
{
    int max = -1;

    for(Map.Entry<String, Forsikringkunde> entry : this.entrySet())
    {
        int entry = Integer.parseInt(entry.getValue().getNumber());
        if(entry > max)
        {
            max = entry;
        } 
    }
    return String.valueOf(max + 1);
}