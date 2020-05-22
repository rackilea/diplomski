for (i = 0; i < msg.length(); ++i) {
    let = msg.charAt(i);
    if ( (Character.isLetter(let)) && ! (Character.isWhitespace(let)) ) {
        System.out.print('?');
    } else {
        System.out.print(let);
    }
}