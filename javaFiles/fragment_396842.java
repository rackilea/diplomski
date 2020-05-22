for(myPanel m : mp)
    {
        m.tock(); // ONCE
    }
    for(short x = 0; x < 3; x++ )
    {
        mp[x].tock(); // TWICE
        jl[x].setText( "" + --tim[x]  );
    }