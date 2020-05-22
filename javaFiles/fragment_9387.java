public class PrintingFooListener extends FooBaseListener {
    @Override 
    public void enterState(FooParser.StateContext ctx)
    {
        // It is possible to get all sorts of token/subrule/text 
        // information from the ctx input, especially if you labeled 
        // the parser/lexer rules. 

        System.out.println("I entered State");
    }
}