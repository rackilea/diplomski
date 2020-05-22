public boolean waitForTextPresent(final String text, long timeout) {
    Wait wait = new Wait() {

        @Override
        public boolean until() {
            try {
                return CustomSelenium.this.isTextPresent(text);
            } catch (SeleniumException e) {
                return false;
            }
        }
    };
    try {
        wait.wait("Error: text " + text + " not present in the page", timeout, 50);
    } catch (NumberFormatException e) {
        log.error(e.getMessage(), e);
        throw e;
    } catch (WaitTimedOutException e) {
        log.warn(e.getMessage(), e);
        return false;
    }
    return true;
}