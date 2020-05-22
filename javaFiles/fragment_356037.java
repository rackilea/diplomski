class Calc implements Expr, Visitor
{
    Expr ast;

    public Expr getAst()
    {
        return ast;
    }

    Calc(Expr ast)
    {
        this.ast = ast;
    }

    public void accept(DotVisitor visitor)
    {
        visitor.visit(ast);
    }

    public void visit(Expr calc)
    {
        output += "Calc\n";
        calc.accept(this);
    }
}