for (Matcher m = p.matcher(t); m.find(); ) {
    for (int i = 1; i <= m.groupCount(); i++) {
        if (m.group(i) != null) {
            System.out.print(i + ", ");
            break;
        }
    }
}