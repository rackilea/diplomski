StringBuffer errorMgs = new StringBuffer();

    errorMgs.append("Sorry !! ");

    if (passWordLower.length() < 9) {
        errorMgs.append("your password must have minimum 9 characters \nand");
    }
    else if (passWordLower.length() > 20) {
        errorMgs.append("your password is greater than or equal too 20 characters \nand");
    }
    if (passWordLower.indexOf(firstNameLower) != -1 || (passWordLower.indexOf(lastNameLower) != -1)) {
        errorMgs.append(" you can not use your first or your last name \nand");
    }
    if (!passWordLower.contains("@")) {
        errorMgs.append(" you must use a @ symbol \nand");

    }
    if (!passWordLower.contains("_")) {
        errorMgs.append(" you must use a underscore \nand");
    }
    int counter = 0;
    for (int i = 0; i < passWordLower.length(); i++) {
        if (Character.isDigit(passWordLower.charAt(i))) {
            counter++;
        }
    }
    if (counter < 3) {
        errorMgs.append(" you need to have at least 3 numbers");
    }

    if (!errorMgs.toString().equals("Sorry !! ")) { //identify given password met all criterias or not   
        errorMgs.append(" in your password.");
        System.out.println(errorMgs);
    } else {
        System.out.println("your password accepted");
    }