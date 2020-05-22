List times = new ArrayList();
previousTime = time.get(0);
for(time : times)
{
    if(time < previousTime)
        return false;
    previousTime = time;
}