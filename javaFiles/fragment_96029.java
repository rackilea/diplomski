public class FruitTest {

    public static void main(String[] args) throws Exception {
        CharStream input = new ANTLRStringStream("[APPLE|ORANGE] PEAR");
        FruitLexer lexer = new FruitLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        FruitParser parser = new FruitParser(tokens);

        parser.addColor("APPLE", "red");
        parser.addColor("ORANGE", "orange");
        parser.addColor("PEAR", "yellow");

        String result = parser.conditionalString();

        if (lexer.getNumberOfSyntaxErrors() > 0 || parser.getNumberOfSyntaxErrors() > 0){
            throw new Exception("Syntax errors encountered!");
        }

        System.out.println(result);
    }
}