public static String toBase26(int number){
    number = Math.abs(number);
    String converted = "";
    // Repeatedly divide the number by 26 and convert the
    // remainder into the appropriate letter.
    do
    {
        int remainder = number % 26;
        converted = (char)(remainder + 'A') + converted;
        number = (number - remainder) / 26;
    } while (number > 0);

    return converted;
}