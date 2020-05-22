public class OracleMatchesSqlServer extends TestCase {
    public void testHeadIdentifiersShouldBeEqual() throws Exception {
        String head = "whatever your head should be";
        IdentifierBean originalBean = YourClass.getHeadIdentifiers_old(head);
        IdentifierBean oracleBean = YourClass.getHeadIdentifiers(head);
        assertEquals(originalBean, oracleBean);
    }
}