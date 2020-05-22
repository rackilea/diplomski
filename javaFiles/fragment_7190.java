interface DistributionProvider<D extends Distribution> {
  D create(ValueRange vr);
}

class UniformDistributionProvider implements DistributionProvider<UniformDistribution> {
  UniformDistribution create(ValueRange vr) {
    return new UniformDistribution(vr);
  }
}

class ForwardMarkovDistributionProvider implements DistributionProvider<ForwardMarkovDistribution> {

  private final MarkovDistribution.Parameters params;

  ForwardMarkovDistributionProvider(MarkovDistribution.Parameters pParams) {
    params = pParams;
  }

  ForwardMarkovDistribution create(ValueRange vr) {
    return new ForwardMarkovDistribution(vr, params);
  }
}

// etc.