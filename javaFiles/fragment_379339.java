public class Singleton {
        private Singleton() {
        }

        private volatile String theVar = null;

        public void setVar(String newVar) {
            synchronized (this) {
                theVar = newVar;
            }
        }

        public String getVar() {
            synchronized (this) {
                return theVar;
            }
        }

        public void appendVar(String text) {
            synchronized (this) {
                theVar += text;
            }
        }

        private static class Provider {
            static final Singleton INSTANCE = new Singleton();
        }

        public static Singleton getInstance() {
            return Provider.INSTANCE;
        }
    }