public class CreateRegionFunction extends FunctionAdapter {

@Override
public void execute(FunctionContext fc) {
    String name = (String) fc.getArguments();
    Region reg = DynamicRegionFactory.get().createDynamicRegion("/parent",
            name);

    if (reg == null) {
        fc.getResultSender().lastResult("ERROR");
    } else {
        fc.getResultSender().lastResult("DONE");
    }
}

@Override
public String getId() {
    return "create-region-function";
}

}