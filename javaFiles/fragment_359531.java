public static void yourTask(char[] arr) {
    CharBuffer.wrap(arr).chars()
        .filter(c -> c >= 'H' && c <= 'N' || c >= 'h' && c <= 'n')
        .map(c -> (Character.isUpperCase(c)? 'A'+'Z': 'a'+'z') - c)
        .forEachOrdered(ch -> System.out.print((char)ch+" "));
}