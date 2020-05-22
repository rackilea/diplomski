public void apply(Statement base, Description description) {
    return new Statement() {
        public void evaluate( ) {
            // some initialisation
            try {
                base.evaluate();
            } finally {
                // some tidy up here
            }
        }
    }
}