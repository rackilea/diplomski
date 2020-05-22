public class Rule {
    private NonTerminal lhs;
    private Symbol[] rhs;

    public Rule(NonTerminal lhs, Symbol... rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
}