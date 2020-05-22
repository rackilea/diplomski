for(ObjectA el : listOfA)
{
    for(ObjectB in : listOfB)
    {
        if(el.remainingtime == in.remainingtime)
        {
            resultList.add(el);
            break;
        }
    }
}