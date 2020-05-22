if ((year % 4) == 0) {
    // could be a leap year
    if ((year % 100) == 0) {
        // could be a leap year too
        if ((year % 400) == 0) {
            println("yes, this is a leap year ... divisible by 4, 100, AND 400");
        } else {
            // not a leap year ... divisible by 4 and 100, but NOT 400
        }
    } else {
        println("yes, this is a leap year ... it's divisible by 4 but not 100");
    }
} else {
    // absolutely not a leap year
}