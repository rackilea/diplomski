public static void main(String[] args) {
    LinkedList<Character> list = new LinkedList<>();
    String linkString = "ZekqmDXJGfaos3MPaSl8p1La.9rXEt43a=Cn#Ds72Y";

    for (int i = 0; i < linkString.length(); i++) {
        list.add(linkString.charAt(i));
    }

    ListIterator<Character> myIterator = list.listIterator(0);

    while (myIterator.hasNext()) {
        char c =  myIterator.next();
        if (c == 'Y') {
            myIterator.set('!');
        }
    }
    while (myIterator.hasPrevious()) {
        char c = myIterator.previous();
        if (c == 'M') {
            myIterator.set(' ');
        }
    }

    System.out.println(list.toString()); // just to see what comes out
}