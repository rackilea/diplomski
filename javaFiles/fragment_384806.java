switch(((View)v.getParent()).getID())
{
case R.id.topHalf:
    if(v instanceof ColonyHutOne)
        topHalfColonyOne();
    else if(v instanceof ColonyHutTwo)
        topHalfColonyTwo();
    break;
case R.id.bottomHalf:
    if(v instanceof ColonyHutOne)
        bottomHalfColonyOne();
    else if(v instanceof ColonyHutTwo)
        bottomHalfColonyTwo();
    break;
}