@Test
public void when_main_is_called_exit_code_should_be_1() throws Exception {
    final int[] exitCode = new int[1];
    System.setSecurityManager(new SecurityManager() {
        @Override
        public void checkExit(int status) {
            exitCode[0] = status;
            throw new RuntimeException();
        }});

    try { main(); } catch(Exception e) {}

    assertEquals(exitCode[0], 1);
}

public static void main() {
    System.exit(1);
}