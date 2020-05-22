private void executeWithLogin(Runnable r) {
    try {
        r.run();
    } 
    catch (Exception e) {
        if (e.getExceptionCode == INVALID_SESSION_ID) {
            //login again
            login();
            //retry on specific code
            r.run();
        }
    }
}

public void create(final SObject[] s){
    executeWithLogin(new Runnable() {
        public void run() {
            binding.create(s);
        }
    });
}

// same for other operations