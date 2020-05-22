public class OracleMatchesSqlServer extends TestCase {
    public void testHeadIdentifiersShouldBeEqual() throws Exception {
        compareIdentifiersWithHead("head1");
        compareIdentifiersWithHead("head2");
        compareIdentifiersWithHead("etc");
    }
    private static void compareIdentifiersWithHead(String head) {
        IdentifierBean originalBean = YourClass.getHeadIdentifiers_old(head);
        IdentifierBean oracleBean = YourClass.getHeadIdentifiers(head);
        assertEquals(originalBean, oracleBean);
    }
}