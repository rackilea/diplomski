public boolean checkOwnerPassword2() {
        String password = "123";
        int i = 0;
        while (i < 3) {
            System.out.println("Enter password");
            String s = userInput();
            if (s.equals(password)){
                return true;
            }
            i++;
        }
        return false;
    }