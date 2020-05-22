@Aspect
public class ArchitecturalEnforcement {
    @Pointcut("...")
    public void implementsInterface() {}

    @Pointcut("...")
    public void definesConstant(){}

    /** Advice that defines an error when a GUI method calls a method in the DAO layer */
    @DeclareWarning("implementsInterface() && !definesConstant()")
    private static final String WARNING= "...";
}