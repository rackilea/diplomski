if (m.find()) {
    System.out.print(m.group() + " ");
    while (m.find()) {
        System.out.print(m.group() + " ");
    }
} else {
    System.out.println("Not found: " + text);
}