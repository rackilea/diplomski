public class myRace
{
    private int distance = 100;
    private float offset = 20;
    public int runners[3];

    public void run()
    {
        // Set all runners to 0
        for ( int i = 0; i < runners.length; i++ )
            runners[i] = 0;

        // Run the race and stop when at least 1 runner has reached the distance...
        boolean finished = false;
        while ( !finished )
        {
            for ( int i = 0; i < runners.length; i++ )
            {
                runners[i] += (int)((Math.random() * offset) + 1);
                if ( runners[i] >= distance ) finished = true;
            }
        }
        // Race finished now sort the runners
        TreeMap<String, int> ranking = new TreeMap<String, int>();
        for ( int i = 0; i < runners.length; i++ )
        {
            // A TreeMap is sorted on its key, not the value!
            // The runners number is tagged on, just in case two runners have finished on the same distance.
            String sortedKey = Integer.toString(runners[i]) + "." + Integer.toString(i);
            ranking.put(sortedKey, i);
        }
        // Print the results
        int pos = 1;
        for ( Map.Entry entry : ranking.entrySet() )
        {
            String key = entry.getKey();
            String distance = key.subString(0, key.indexOf(".")); // chop off the "." + runners number.

            System.out.println("#" + pos +    // position
                "." + entry.getValue() +      // who
                ", Distance = " + distance);  // distance covered

            pos++; // this does take in account whether multiple runners finished on the same distance.
        }
    }
}