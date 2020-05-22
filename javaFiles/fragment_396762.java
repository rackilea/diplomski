if(getPoint1X > 0 && getPoint2X > 0 && getPoint1X < getPoint2X)
{
    replaceVarX = blockSelector.getBlockX() + 1;
}
else if(getPoint1X > 0 && getPoint2X > 0 && getPoint1X > getPoint2X)
{
    replaceVarX = blockSelector.getBlockX() - 1;
}
else if (getPoint1X < 0 && getPoint2X < 0 && getPoint1X < getPoint2X)
{
    replaceVarX = blockSelector.getBlockX() + 1;
}
else if (getPoint1X < 0 && getPoint2X < 0 && getPoint1X > getPoint2X)
{
    replaceVarX = blockSelector.getBlockX() - 1;
}
else if (getPoint1X > 0 && getPoint2X < 0)
{
    replaceVarX = blockSelector.getBlockX() - 1;
}
else if (getPoint1X < 0 && getPoint2X > 0)
{
    replaceVarX = blockSelector.getBlockX() + 1;
}
else if (getPoint1Z < 0 && getPoint2Z < 0 && getPoint1Z < getPoint2Z)
{
    replaceVarX = blockSelector.getBlockX() + 1;
}