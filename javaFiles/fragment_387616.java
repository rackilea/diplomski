public enum EvaluationType {
    PEER {
        @Override
        public void foo() {
            ...
        }
    },
    TEAM {
        @Override
        public void foo() {
            ...
        }
    };

    public abstract void foo();
}

public class Evaluation {
    private EvaluationType type;

    public void foo() {
        return this.type.foo();
    }
}