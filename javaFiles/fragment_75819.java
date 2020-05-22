abstract class GenericBuilder<B extends GenericBuilder<B>> {

    public B lastBuildingMethodInTheChain(Object someValue) {
        // assignment
        return (B) this;
    }
}