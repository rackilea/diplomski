final Engine<DoubleGene, Double> engine = ...
final EvolutionStatistics<Double, DoubleMomentStatistics> statistics =
    EvolutionStatistics.ofNumber();

final Phenotype<DoubleGene, Double> result = engine.stream()
    .limit(bySteadyFitness(7))
    .limit(100)
    .peek(statistics)
    .collect(toBestPhenotype());

System.println(statistics);