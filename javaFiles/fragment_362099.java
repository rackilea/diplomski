try {
    Integer.parseInt(yourString);
    //new BigInteger(yourString);
    //Use the above if parsing amounts beyond the range of an Integer.
} catch (NumberFormatException e) {
    /* Fix the problem */
}