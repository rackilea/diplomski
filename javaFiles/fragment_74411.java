interface Value {
    double getValue();
    void accept(ValueVisitor visitor);
}

interface ValueVisitor {
    public void visit(MeanValue value);
    public void visit(StdDevValue value);
}

class MeanValue implements Value {
    @Override
    public double getValue() {
        // whatever
    }

    @Override
    public void accept(ValueVisitor visitor) {
        visitor.visit(this);
    }
}

class StdDevValue implements Value {
    @Override
    public double getValue() {
        // whatever
    }

    public int getDegreesOfFreedom() {
        // here's a subclass-specific method
    }

    @Override
    public void accept(ValueVisitor visitor) {
        visitor.visit(this);
    }
}