@Override
protected Vector doInBackground()
{       
    int i = 0;
    while(i < 100000000)
    {
        Vector v = new Vector();
        v.add(i);

        i++;             
        publish(v); 
    }

    return v;
}