private static String password = "123";

    public static void main(String[] args) {

        // read the input password from console
        // if you have UI, maybe you can read it from some way.
        Scanner sc = new Scanner(System.in);
        String inputPassword = sc.next();
        while (true) {
            //do something...
            try {
                unzip(inputPassword);
                break;
            } catch (Exception e) {
                inputPassword = sc.next();
            }

        }
    }

    private static void unzip(String inputPassword) {
        if (inputPassword.equals(password)) {
            //unzip
        } else {
            // just demo. In your case, this is ZipException
            throw new IllegalArgumentException("wrong password");
        }
    }