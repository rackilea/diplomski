List<List<String>> list;
int x = 0;
int y = 0;
while(x < list.size())
{
    if(y < list.get(x).size())
    {
        //do stuff with list.get(x).get(y)
        y++;
    }
    else
    {
        x++;
        y = 0;
    }
}