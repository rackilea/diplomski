public class ScannerTest {

    static private final String text = "FUNCTION_BLOCK Unnamed_project\n\tVAR_INPUT\n\t\tUnnamed_variable1 : REAL;\n\tEND_VAR\nEND_FUNCTION_BLOCK";
    public static final String WHITESPACE = "[ \\n\\t]+";

    @Test
    public void scannerSkipTest() {

        Scanner sc = new Scanner(new StringReader(text));
        sc.useDelimiter(WHITESPACE);
        sc.skip("FUNCTION_BLOCK");
        String blockName = sc.next();
        sc.skip(WHITESPACE + "VAR_INPUT");
        String variableName = sc.next();
        sc.skip(WHITESPACE + ":");
        String typeWithSemiColon = sc.next();
        sc.skip(WHITESPACE + "END_VAR");
        sc.skip(WHITESPACE + "END_FUNCTION_BLOCK");

        assert "Unnamed_project".equals(blockName);
        assert "Unnamed_variable1".equals(variableName);
        assert "REAL;".equals(typeWithSemiColon);
    }
}