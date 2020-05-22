private class AuthManager {

        private volatile boolean reAuthenticate;
        public boolean reAuthenticate(){
            if (!reAuthenticate) {
                synchronized (this) {
                    if (!reAuthenticate) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            // ignored
                        }

                        System.out.println("Reauthenticating..");

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            // ignored
                        }
                        return this.reAuthenticate = true;
                    }
                }
            }
            return false;
        }