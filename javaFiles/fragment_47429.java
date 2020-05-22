public void setValues(int above, int below)
{
    midPoint = getHeight() / 2;
    heightAbove = Math.abs(above);
    heightBelow = Math.abs(below);
    /*
     * If both are negative values, 
     * we need a Mid-Point in this case.
     */
    if (above < 0 && below < 0)
    {
        rectAbove = midPoint;
        diff = 120;
        rectBelow = midPoint;
        flag = true;
    }
    else if (above >= 0 && below >= 0)
    {
        rectAbove = getHeight() - heightAbove;
        diff = 120;
        rectBelow = getHeight() - heightBelow;
        flag = false;
    }
    else if (above < 0 && below >= 0)
    {
        rectAbove = midPoint;
        diff = 40;
        rectBelow = midPoint - heightBelow;
        flag = true;
    }
    else if (above >= 0 && below < 0)
    {
        rectAbove = midPoint - heightAbove;
        diff = 40;
        rectBelow = midPoint;
        flag = true;
    }       

    repaint();
}