package sandbox;

public class Sandbox
{

    public static void main(String[] args)
    {
        int numBuckets = 12;
        int numItems = 34;

        int itemsPerBucket = (numItems / numBuckets);
        int remainingItems = (numItems % numBuckets);

        for (int i = 1; i <= numBuckets; i++)
        {
            int extra = (i <= remainingItems) ? 1:0;
            System.out.println("bucket " + i + " contains " + (itemsPerBucket + extra) + " items.");
        }
    }
}