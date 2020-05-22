String price = <get price somehow>;    
try {
    if (price != null && Integer.valueOf(price) > 0) {
        do something with price...
    }
} catch (NumberFormatException exception) {
}