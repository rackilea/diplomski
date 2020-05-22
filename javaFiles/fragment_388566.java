public class ProductionCodeClass {

    private final DependencyClass dependency;

    @Inject
    public ProductionCodeClass(DependencyClass dependency) {
        this.dependency = dependency;
    }
}