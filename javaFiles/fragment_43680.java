public String getRandomString() {
    int number = (int)(Math.random() * 100)
    if(number >= 0 && number <= 15) return "item1";
    if(number >= 16 && number <= 35) return "item2";
    if(number >= 36 && number <= 65) return "item3";
    if(number >= 66 && number <= 85) return "item4";
    if(number >= 86 && number <= 95) return "item5";
    if(number >= 96 && number <= 99) return "item6";

    // the computer will never get to here, but the compiler doesn't know that
    // (though it might happen if you change the numbers above, and don't
    // cover all the numbers 1 to 99)
    throw new RuntimeException("this shouldn't happen!");
}