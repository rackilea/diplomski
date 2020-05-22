for (final String s : string.split(" ")) {
    if (s.contains("\n")) {
        System.out.print(s);
        System.out.println(" END");
    }
}