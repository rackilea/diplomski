String changedNumber="";//declare outside loop
    //...
    if (Character.isDigit(c) == true) {
        changedNumber += String.valueOf(c);
    } else if (Character.isLetter(c) == true) {
        changedNumber += String.valueOf(decode(c));
    } else {
        System.out.println("Improper input");
    }