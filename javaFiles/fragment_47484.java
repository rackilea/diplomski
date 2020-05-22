public void expansion()//here's where the expansion begins
    {
        int newSize = a.length + increment;
            Comparable[] tempArray = new Comparable[newSize];
            for(int i= 0; i < a.length; i++)
            {
                tempArray[i]= a[i];
            }
            a  = tempArray;
    }