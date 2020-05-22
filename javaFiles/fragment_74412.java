abstract class Outputter implements ValueVisitor {
    public void output(Collection<? extends Value> values) {
        for (Value value : values) {
            value.accept(this);
        }
    }
}

class PrintingOutputter extends Outputter {
    @Override
    public void visit(MeanValue value) {
        System.out.println("Mean: " + value.getValue());
    }

    @Override
    public void visit(StdDevValue value) {
        System.out.println("Std Dev: " + value.getValue() + " (" + value.getDegreesOfFreedom() + ")");
    }
}