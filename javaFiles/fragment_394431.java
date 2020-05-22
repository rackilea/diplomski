public Name remove()
{
    Name temp2 = names[0];
    //Save first element

    names[0] = names[idx];
    //Move last element to first

    num--;
    while(idx < Math.max(2*idx+1,2*idx+2))
    {
        if(names[idx].CompareTo(names[(idx-1)/2]) > 0)
                {
                    Name temp3 = names[idx];
                    names[idx] = names[(idx-1)/2];
                    names[(idx-1)/2] = temp3;
                }
    }
    return temp2;
}