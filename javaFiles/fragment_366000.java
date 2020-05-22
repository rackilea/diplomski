Pattern p = Pattern.compile(".*?(\\d+\\.\\d+\\.\\d+-dev).*");
    Matcher m = p.matcher("filename:foobar0.2.3-dev.zip");
    if (m.matches()) {
        System.out.println(m.group(1));
    }
    else {
        System.out.println("Pattern does not match");
    }