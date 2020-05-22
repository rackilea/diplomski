public static void main(String[] arguments) throws FileNotFoundException {
    Matcher m = Pattern.compile("[A-M|O-Z]{4}").matcher(
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNTT"
                    + "CAANGGGACGGAGCGGGTGCNGTNNCNGGANAGANNCNTC"
                    + "NATNANCNNGAGGAGNNCNNGCGCTTCGACAGCGACGTGG"
                    + "GGGAGTNCNNGGCGGTGACNGAGCTNGGGCGGCCTNNNGN"
                    + "NGAGNNCTGGAACAGCCAGAAGGACNTCCTGGANNNNNNN"
                    + "CNNGNCNNNGTGGACANNNNNTGCAGACACAACTACGGGG"
                    + "NTGNNNNNNNNNNNNNNNNNNNNNNNNNNN");

    int index = 0;
    while (m.find(index)) {
        index = m.start() + 1;
        System.out.println(m.group());
    }
}