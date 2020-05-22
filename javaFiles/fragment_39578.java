public String multiply(String input) {
    int result = 0;
    int position = input.length();
    while(0 <= --position)
        result += (input.charAt(position) - 0x30) << (position & 01l);
    return Integer.toString(result);
}