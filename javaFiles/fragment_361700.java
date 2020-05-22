Tablet[] T = new Tablet[6];
    for(int i = 0;i<6;i++)
    {
        T[i]=new Tablet();
        T[i].set("111"); // No Null Pointer Exception Now
    }