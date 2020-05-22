import org.apache.commons.math3.distribution.NormalDistribution;

public class TestProbabilites {

    public static void main(String[] args) {
        double riskProbabilityLevel = 0.02D;
        double mean = 0.06618D;
        double standardDev = 0.057196166520267355D;
        double expectedRisk = 0.051286461995869864D;

        NormalDistribution distribution = new NormalDistribution(mean, standardDev);
        double outcomeRisk = distribution.inverseCumulativeProbability(riskProbabilityLevel);
    }
}