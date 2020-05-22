public class ResetableIdGenerator extends SequenceGenerator {
               public static int cycle = 0; // global, indicating current test cycle
               protected int startingCycle = 0; // instance, indicating the test cycle the LegacyHiLoAlgorithmOptimizer was used the last time
    [...]
        public synchronized Serializable generate(final SessionImplementor session, Object obj) {
            // create a new HiLoOptimizer if there's a new test cycle
            if (startingCycle < cycle) {
                hiloOptimizer = new OptimizerFactory.LegacyHiLoAlgorithmOptimizer(getIdentifierType().getReturnedClass(),
                        maxLo);
                startingCycle = cycle;
            }
[....]