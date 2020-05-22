public String createPassword() {
        StringBuilder pass = new StringBuilder();
        Random r = new Random();

        for(int i = 0 ; i < length ; i++) {
            pass.append( (char)('a' + r.nextInt('z'-'a')) );
        }
        return pass.toString();
    }