while(iter.hasNext()) 
{
    String temp = iter.next();
    //this is a more old school method but more true to form. 
    //== doesn't necessarily do equality checks on all objects the way
    //you would think 
    if(temp.equals(sampleString)) 
    {
        test2.add(temp);
    }
}