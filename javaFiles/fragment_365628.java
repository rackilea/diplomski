for(int i = 0; i < numWaves;i++) // upper range should be the number of waves
{
    if(w.get(i).beat)
    {
        if(i>0)   // this can be simplified to "if (i>0)"
        {
            if(w.get(i-1).beat)  // no need to check w.get(i).beat here
            {
                w.get(i).beat = false;
            }
        }
    }
    else 
        w.get(i).update(g2d);
}