@Override
public List<ParameterType> getParameterTypes() {
    List<ParameterType> types = super.getParameterTypes();
    types.add(new ParameterTypeDouble(MinSupp, "Defines the the minimum frequence of an Itemset", 0.0, 1.0));
    types.addAll(RandomGenerator.getRandomGeneratorParameters(this));
    return types;
}