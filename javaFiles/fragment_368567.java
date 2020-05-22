for(int i = 0; i >= 0;)
    {
        ...
        double[] contourInfo = hierarchy.Get(0, i);
        i = (int)contourInfo[0]; // this gives next sibling
    }