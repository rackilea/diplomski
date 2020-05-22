public static void main(String... args) {
    String[] formats = { 
        // NOTE - In a real app, you'd fetch the format strings from a language,
        // file, not hard-code them in your program. Obviously.
        "{0,number} {0,choice,0#years|1#year|1<years}", // english
        "{0,number} {0,choice,0#años|1#año|1<años}", // spanish
        "{0,number} {0,choice,1#[fewer than 2]|2#lata|4<lat}", // polish
        "{0,number} år", // swedish - singular and plural forms look the same!
    };
    int[] years = {0, 1, 2, 3, 4, 5, 6};
    for (int year : years) {
        for (String format : formats) {
            System.out.println(MessageFormat.format(format, year));
        }
        System.out.println();
    }
}