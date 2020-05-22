int index = -1; // not found

for(int i = 0; i < data.length; i++)
{
    if(data[i].equals(value))
    {
        index = i;
        break; // stop looking
    }
}