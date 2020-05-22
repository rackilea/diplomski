String[] strs = new String[] {
    "LCK_card_L02NOR19999_2012-11-07-121600", // Invalid
    "BLTM_L183ROP3289_2012-11-07-121601", // Valid one
    "TEMP_LCK_card_L02NOR19999_2012-11-07-121600" // Valid one
};

String pattern = "^(?!(LCK_|OPN_))(.*)((19|20)[0-9]{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])-[0-9]{6}).*";

for (String string : strs) {
    boolean m = string.matches(pattern);
    System.out.println(m ? "Valid" : "Invalid");
}