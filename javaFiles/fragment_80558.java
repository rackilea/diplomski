package myUtil;

@SuppressWarnings("serial")
public class SortedArrayList<T extends Comparable<T>>extends java.util.ArrayList<T>
{
    public SortedArrayList() {}

    public SortedArrayList(int capacity) {}

    @Override
    public boolean add(T item)
    {
        int index=this.size();
        //Adds item to every position until it finds one that works
        for (int i=0;i<=index;i++)
        {
            try
            {
                add(i,item);
                break;
        }
            catch (IllegalArgumentException e) {}
        }   
        return true;
    }



    @Override
    public void add(int i, T item)
    {
        //Tests for special cases with if statements.
        //If item is inserted into the wrong place, throws IllegalArgumentException()
        if (i<=size())
        {
            if (size()==0) super.add(item);
            else if (i==size())
            {
                if(item.compareTo(this.get(i-1))>=0)
                    super.add(i, item);
                else throw new IllegalArgumentException();
            }
            else if (i==0)
            {
                if(item.compareTo(this.get(i))<=0)
                    super.add(i, item);
                else throw new IllegalArgumentException();
            }
            else
            {
                if(item.compareTo(this.get(i-1))>=0&&item.compareTo(this.get(i))<=0)
                    super.add(i, item);
                else throw new IllegalArgumentException();
            }
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
}