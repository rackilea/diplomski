@Test
    public void test() {    
        final Object a = new Object();
        final Object b = new Object();

        boolean result = waitUntil(new Callable() {
            public boolean call() {
                return a.equals(b);
            }
        });

        assertTrue(result);
    }

    public boolean waitUntil(final Callable func) {
        try {
            wait.until(new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return func.call();// <=================== some expression 
                }
            }); 
        } catch (Exception ex) {
            return false;
        }
        return true;
    }


    public interface Callable {
        public boolean call();
    }