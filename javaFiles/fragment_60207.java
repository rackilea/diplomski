public interface IFirst { public void foo(); }

public interface ISecond { public void bar(); }

public class Third implements IFirst, ISecond {
    private IFirst first;
    private ISecond second;

    public Third(IFirst first, ISecond second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public void foo() {
        first.foo();
    }
    @Override
    public String bar() {
        return second.bar();
    }
}