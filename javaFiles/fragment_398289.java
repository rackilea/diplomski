StringBuilber reverse = new StringBuilder();
while (!original.equalsIgnoreCase("END")) {
    reverse.append(new StringBuilder(original).reverse()).append(" ");
    original = kb.next();
}
System.out.println("Reverse: " + reverse.reverse().toString());