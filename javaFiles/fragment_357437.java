Pattern.compile("(?=.*[A-Z])"
                + "(?=.*[a-z])"
                + "(?=.*[0-9])"
                + ".{8,12}").matcher("passworD12345678").matches();
//                 ^^^^^^^ we can't use look-ahead because we need some part of regex 
//                         which will let regex consume all characters from string