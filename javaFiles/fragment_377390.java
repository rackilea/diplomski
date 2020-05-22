interface IRequestBuilder {
    public String processParameters();
}

interface IMyRequestBuilder extends IRequestBuilder {
    @Override
    default String processParameters() {
        return createBody();
    }
    String createBody();
}
class A implements IMyRequestBuilder {

}