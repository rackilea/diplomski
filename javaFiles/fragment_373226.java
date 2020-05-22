final PrettyPrinter printer = new PrettyPrinter(out);
printer.print(new String[][] {
        new String[] {"FIRST NAME", "LAST NAME", "DATE OF BIRTH", "NOTES"},
        new String[] {"Joe", "Smith", "November 2, 1972"},
        null,
        new String[] {"John", "Doe", "April 29, 1970", "Big Brother"},
        new String[] {"Jack", null, null, "(yes, no last name)"},
});