public class Main
{
    public static void main( String[] args )
    {
        Map< TimeSpentStats, MinMax > hashMap = new HashMap< TimeSpentStats, MinMax >();
        addToMap( hashMap, new TimeSpentStats( 1, "01F", 5, 1000L ) );
        addToMap( hashMap, new TimeSpentStats( 1, "01F", 5, 1005L ) );
        addToMap( hashMap, new TimeSpentStats( 3, "6Y", 3, 7L ) );
        addToMap( hashMap, new TimeSpentStats( 3, "6Y", 3, 16L ) );

        for ( Map.Entry< TimeSpentStats, MinMax > entry : hashMap.entrySet() )
        {
            TimeSpentStats timeSpentStats = entry.getKey();
            MinMax minMax = entry.getValue();
            System.out.println( timeSpentStats.getManId() + "\t" + timeSpentStats.getSessionId() + "\t" + timeSpentStats.getUserId() + "\tMin Time Stamp :" + minMax.getMin() + "\tMax Time Stamp :" + minMax.getMax() );
        }
    }

    private static void addToMap( Map< TimeSpentStats, MinMax > hashMap, TimeSpentStats timeSpentStats )
    {
        MinMax timeStampMinMax = hashMap.get( timeSpentStats );
        if ( timeStampMinMax != null )
            timeStampMinMax.updateValues( timeSpentStats.getTimeStamp() );
        else
            hashMap.put( timeSpentStats, new MinMax( timeSpentStats.getTimeStamp() ) );
    }
}

class MinMax
{
    private Long min;
    private Long max;

    MinMax( Long timeStamp )
    {
        this.min = timeStamp;
        this.max = timeStamp;
    }

    public Long getMin()
    {
        return min;
    }

    public Long getMax()
    {
        return max;
    }

    public boolean updateValues( Long timeStamp )
    {
        if ( timeStamp < this.min )
        {
            this.min = timeStamp;
            return true;
        }
        else if ( timeStamp > this.max )
        {
            this.max = timeStamp;
            return true;
        }

        return false;
    }
}

class TimeSpentStats
{
    private final int manId;
    private final String sessionId;
    private final int userId;
    private final Long timeStamp;

    public TimeSpentStats( int manId, String sessionId, int userId, Long timeStamp )
    {
        this.manId = manId;
        this.sessionId = sessionId;
        this.userId = userId;
        this.timeStamp = timeStamp;
    }

    public int getManId()
    {
        return manId;
    }

    public String getSessionId()
    {
        return sessionId;
    }

    public int getUserId()
    {
        return userId;
    }

    public Long getTimeStamp()
    {
        return timeStamp;
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( obj instanceof TimeSpentStats )
        {
            TimeSpentStats timeSpentStats = (TimeSpentStats)obj;
            return this.manId == timeSpentStats.manId && this.sessionId.equals(timeSpentStats.sessionId) && this.userId == timeSpentStats.userId;
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return sessionId.hashCode();
    }
}