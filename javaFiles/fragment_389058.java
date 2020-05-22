import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.NormalDistribution;
import org.apache.commons.math.distribution.NormalDistributionImpl;

/**
 * @see http://stattrek.com/Tables/Normal.aspx#examples
 * @see https://stackoverflow.com/questions/6353678
 */
public class CumulativeProbability {

    private static NormalDistribution d;

    public static void main(String[] args) throws MathException {
        // Problem 1; µ = 1000; σ = 100
        d = new NormalDistributionImpl(1000, 100);
        System.out.println(d.cumulativeProbability(1200));
        // Problem 2; µ = 50; σ = 10
        d = new NormalDistributionImpl(50, 10);
        System.out.println(d.inverseCumulativeProbability(0.9));
    }
}