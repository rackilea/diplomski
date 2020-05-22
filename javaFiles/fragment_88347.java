for (int i=0;i<res.length;i++)
{
    int flag=1;
    String s1=res[i].toLowerCase();

    for(int j=0;j<stopwords.length;j++)
    {
        if(s1.equals(stopwords[j]))
        {
            flag=0;
        }
        // -------- We are still looping through stopwords!  This for loop should be closed here! ---------
        if(flag!=0)
        {
            if (s1.length() > 0) 
            { 
                //Now this is going to add to the list for every entry in stopwords, until we find a match!
                Integer frequency = (Integer) map.get(s1);
                if (frequency == null) 
                {
                    frequency = ONE;
                } else 
                {
                    int value = frequency.intValue();
                    frequency = new Integer(value + 1);
                }
                map.put(s1, frequency);
            }  
        }
    }
}