import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class HistogramStatistics
{
    public static Double average(final Map<Long, Long> histogram)
    {
        return HistogramStatistics.mean(histogram);
    }

    public static Double mean(final Map<Long, Long> histogram)
    {
        double sum = 0L;

        for (Long value : histogram.keySet())
        {
            sum += (value * histogram.get(value));
        }

        return sum / (double) HistogramStatistics.count(histogram);
    }

    public static Double median(final Map<Long, Long> histogram)
    {
        return HistogramStatistics.percentile(histogram, 0.50d);
    }

    public static Double percentile(final Map<Long, Long> histogram, final double percent)
    {
        if ((percent < 0d) || (percent > 1d))
        {
            throw new IllegalArgumentException("Percentile must be between 0.00 and 1.00.");
        }

        if ((histogram == null) || histogram.isEmpty())
        {
            return null;
        }

        double n = (percent * (HistogramStatistics.count(histogram).doubleValue() - 1d)) + 1d;
        double d = n - Math.floor(n);
        SortedSet<Long> bins = new ConcurrentSkipListSet<Long>(histogram.keySet());
        long observationsBelowBinInclusive = 0L;
        Long lowBin = bins.first();

        Double valuePercentile = null;

        for (Long highBin : bins)
        {
            observationsBelowBinInclusive += histogram.get(highBin);

            if (n <= observationsBelowBinInclusive)
            {
                if ((d == 0f) || (histogram.get(highBin) > 1L))
                {
                    lowBin = highBin;
                }

                valuePercentile = lowBin.doubleValue() + ((highBin - lowBin) * d);

                break;
            }

            lowBin = highBin;
        }

        return valuePercentile;
    }

    public static Long count(final Map<Long, Long> histogram)
    {
        long observations = 0L;

        for (Long value : histogram.keySet())
        {
            observations += histogram.get(value);
        }

        return observations;
    }
}