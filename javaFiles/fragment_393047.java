public class ZqlEvalDemo {
    public static void main(String args[]) throws Exception {
        System.out.println(evaluate("SELECT 2+2 FROM RESULT;"));
        System.out.println(evaluate("SELECT 3+7-5 FROM RESULT;"));
        System.out.println(evaluate("SELECT 2*2*2+1 FROM RESULT;"));
    }

    private static ZqlParser p = new ZqlParser();
    private static Object evaluate(String s) throws Exception {
        p.initParser(new java.io.ByteArrayInputStream(s.getBytes()));
        ZStatement st = p.readStatement();
        ZSelectItem zSelectItem = ((ZQuery) st).getSelect().get(0);
        ZExpression exp = (ZExpression) zSelectItem.getExpression();
        return new ZEval().evalExpValue(new ZTuple(), exp);
    }
}