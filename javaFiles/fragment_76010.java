String line = "addPhoto \"DSC_018.jpg\" \"DSC_018\" \"Colorado Springs\"";
    String[] pieces = line.split(" \"");

    for (String p : pieces) {
        System.out.println(p.replaceAll("\"", ""));
    }