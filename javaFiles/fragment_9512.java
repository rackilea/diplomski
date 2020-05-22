public static String main(String args[]){
        String gen;
        if (args != null){
            gen = generatePassword(args[0]);
        }else{
            gen = generateRandomString();
        }
        return gen;
    }