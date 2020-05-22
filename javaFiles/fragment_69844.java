try {
    double value = Double.parseDouble(test1);
    if(value<0)
       System.out.println(value + " is negative");
    else
       System.out.println(value + " is possitive");
} catch (NumberFormatException e) {
    System.out.println("String "+ test1 + "is not a number");
}