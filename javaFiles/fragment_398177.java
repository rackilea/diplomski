interface AlgorithmFactory {
    public abstract Algorithm createAlgorithm();
}

class SpecializedFactory implements AlgorithmFactory {
    @Override
    public Specialized createAlgorithm() {
        return new Specialized();
    }
}