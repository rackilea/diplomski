// 1. String start with alpha word and then followed by
//    any aplha or number. e.g. Abc 20 Jan to 15 Dec

// One or more alpha-characters, followed by a space,
//     followed by some alpha-numeric character, followed by what ever
Pattern p = Pattern.compile("\\p{Alpha}+ \\p{Alnum}.*");
for (String s : new String[] {"Abc 20 Jan to 15 Dec", "hello world", "123 abc"})
    System.out.println(s + " matches: " + p.matcher(s).matches());

// 2. String for a decimal number. e.g. 450,122,224.00
p = Pattern.compile(
        "\\p{Digit}+(\\.\\p{Digit})?|" +  // w/o thousand seps.
        "\\p{Digit}{1,3}(,\\p{Digit}{3})*\\.\\p{Digit}+"); // w/ thousand seps.
for (String s : new String[] { "450", "122", "224.00", "450,122,224.00", "0.0.3" })
    System.out.println(s + " matches: " + p.matcher(s).matches());


// 3. Also to check if String contain any pattern like 'Page 2 of 20'

// "Page" followed by one or more digits, followed by "of"
// followed by one or more digits.
p = Pattern.compile("Page \\p{Digit}+ of \\p{Digit}+");
for (String s : new String[] {"Page 2 of 20", "Page 2 of X"})
    System.out.println(s + " matches: " + p.matcher(s).matches());