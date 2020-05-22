Runnable[] options = {
    new Runnable() {
        public void run() {
            System.out.println("valid");
        }
    },

    new Runnable() {
        public void run() {
            System.out.println("invalid");
        }
    }
};

options[n].run();