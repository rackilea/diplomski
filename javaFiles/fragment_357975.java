private static boolean validateCode(String code) {
    if (code.length() != 6) {
        return false;
    } else {
        boolean valid = true;
        //First character is always an upper case I or a lower case i
        if (code.charAt(0) != 'I' && code.charAt(0) != 'i') {
            System.out.println("integer is not an I or i");
            valid = false;
        }
        // Second character is always an upper case T or a lower case t
        if (code.charAt(1) != 'T' && code.charAt(1) != 't') {
            System.out.println("integer is not a T or t");
            valid = false;
        }
        // Third, fourth, fifth, and sixth characters are always digits (0-9)
        if (!Character.isDigit(code.charAt(2))) {
            System.out.println("integer 3 is not a number");
            valid = false;
        }
        if (!Character.isDigit(code.charAt(3))) {
            System.out.println("integer 4 is not a number");
            valid = false;
        }
        if (!Character.isDigit(code.charAt(4))) {
            System.out.println("integer 5 is not a number");
            valid = false;
        }
        if (!Character.isDigit(code.charAt(5))) {
            System.out.println("integer 6 is not a number");
            valid = false;
        }
        return valid;
    }
}