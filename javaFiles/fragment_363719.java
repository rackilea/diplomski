Pattern rangePattern = Pattern.compile("([0-9]+)\\.([0-9]+)-([0-9]+)=(.*)$");
    Matcher rangeMatcher = rangePattern.matcher("0900.13-17=First label");

    if (rangeMatcher.matches()) {

        String prefix = rangeMatcher.group(1);
        int start = Integer.parseInt(rangeMatcher.group(2));
        int end = Integer.parseInt(rangeMatcher.group(3));
        String label = rangeMatcher.group(4);

        for (int r = start; r < end; r++) {
            System.out.println(prefix + "." + r + "=" + label);
        }
    }