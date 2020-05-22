class ConnectThread implements Callbale<ApplicationConnection> {

    public ApplicationConnection call() {
        try {
            return prioprietaryApi.connect();
        } catch(InterruptedException e) {
            prioprietaryApi.cleanUp();
            throw e;
        }
    }

}