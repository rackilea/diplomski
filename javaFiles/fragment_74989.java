String[] lines = {
        "Sample.3cb11b[1].books.addressDetail.addrDetail2",
        "Sample.3cb11b[28].books.addressDetail.addrDetail2",
        "Sample.3cb11b[0].books.addressDetail.addrDetail2"};
    for (String line: lines) {
        System.out.println(line + ": "
                + line.matches(".*\\[0*[1-9][0-9]*\\].*"));
    }