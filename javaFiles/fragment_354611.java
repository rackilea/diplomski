@Test
public void testTerribleCase() throws ModuleException {
    class TerribleFilter implements Filter {
        boolean seen;
        @Override
        public boolean isLoggable(LogRecord record) {
            if ("This is terrible!".equals(record.getMessage())) {
                seen = true;
            }
            return true;
        }
    }

    Logger log = Logger.getLogger(MyClass.class.getName());
    TerribleFilter tf = new TerribleFilter();
    log.setFilter(tf);
    try {
        myMethod("terrible");
        assertTrue(tf.seen);
    } finally {
        log.setFilter(null);
    }
}