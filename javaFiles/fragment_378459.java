public class Tester {

    public enum Status{
        ONE, TWO;
    }

    public static void main(String[] args) throws JClassAlreadyExistsException, IOException {
        JCodeModel codeModel = new JCodeModel();

        JClass ref = codeModel.ref(Status.class);

        JDefinedClass outputClass = codeModel._class("Output");

        outputClass.field(JMod.PRIVATE, ref, "status", ref.staticRef(Status.ONE.name()));

        codeModel.build(new StdOutCodeWriter());
    }
}