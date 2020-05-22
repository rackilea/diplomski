public class RobotTest {

    @Test
    public void tokenizeMoveCommand() {
        String cmd = "STEP 10";
        SimpleCharStream cs = new SimpleCharStream(new StringReader(cmd));
        RobotTokenManager ltm = new RobotTokenManager(cs);
        Token t = ltm.getNextToken();
        assertEquals(RobotConstants.STEP, t.kind);
        t = ltm.getNextToken();
        assertEquals(RobotConstants.NUM, t.kind);
    }

    @Test(expected = TokenMgrError.class)
    public void tokenizeFailure() {
        String cmd = "STOP 10";
        SimpleCharStream cs = new SimpleCharStream(new StringReader(cmd));
        RobotTokenManager ltm = new RobotTokenManager(cs);
        ltm.getNextToken();
    }
}