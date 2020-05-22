public abstract class AbstractImplementation {

    @PostConstruct
    public abstract init(..);
}

public class ImplementingBean extends AbstractImplementation {
    public init(..) {
        ....
    }
}