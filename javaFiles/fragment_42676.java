for (Matcher m = p.matcher(t); m.find(); ) {
    if (m.group(1) != null) {
        System.out.print("1, ");
    } else {
        System.out.print("2, ");
    }
}