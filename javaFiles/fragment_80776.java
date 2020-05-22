public static void main(String[] args) {
    // two date time Strings
    String datetimeOne = "19:08:58.012345678"; // one with a leading zero nano
    String datetimeTwo = "19:08:58.123456789"; // and one without

    // several patterns that might be interesting
    DateTimeFormatter singleNPatternDtf = DateTimeFormatter.ofPattern("HH:mm:ss.n");
    DateTimeFormatter eightNsPatternDtf = DateTimeFormatter.ofPattern("HH:mm:ss.nnnnnnnn");
    DateTimeFormatter nineNsPatternDtf = DateTimeFormatter.ofPattern("HH:mm:ss.nnnnnnnnn");
    DateTimeFormatter tenNsPatternDtf = DateTimeFormatter.ofPattern("HH:mm:ss.nnnnnnnnnn");

    // parse the two Strings
    LocalTime localTimeOne = LocalTime.parse(datetimeOne, DateTimeFormatter.ISO_LOCAL_TIME);
    LocalTime localTimeTwo = LocalTime.parse(datetimeOne, DateTimeFormatter.ISO_LOCAL_TIME);

    // print / format both and LocalTime.now() with the single 'n' pattern
    System.out.println("1 * n:\t" + localTimeOne.format(singleNPatternDtf) + "\t—\t"
            + localTimeTwo.format(singleNPatternDtf) + "\t—\t" 
            + LocalTime.now().format(singleNPatternDtf));
    // print / format both and LocalTime.now() with eight 'n's pattern
    System.out.println("8 * n:\t" + localTimeOne.format(eightNsPatternDtf) + "\t—\t"
            + localTimeTwo.format(eightNsPatternDtf) + "\t—\t" 
            + LocalTime.now().format(eightNsPatternDtf));
    // print / format both and LocalTime.now() with nine 'n's pattern
    System.out.println("9 * n:\t" + localTimeOne.format(nineNsPatternDtf) + "\t—\t"
            + localTimeTwo.format(nineNsPatternDtf) + "\t—\t" 
            + LocalTime.now().format(nineNsPatternDtf));
    // print / format both and LocalTime.now() with ten 'n's pattern
    System.out.println("10 * n:\t" + localTimeOne.format(tenNsPatternDtf) + "\t—\t"
            + localTimeTwo.format(tenNsPatternDtf) + "\t—\t" 
            + LocalTime.now().format(tenNsPatternDtf));
}