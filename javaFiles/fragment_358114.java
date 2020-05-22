while(nextPart) {
    String header = multipartStream.readHeaders();
    System.out.println("");
    System.out.println("Headers:");
    System.out.println(header);
    System.out.println("Body:");
    if (header.contains("Content-Type: image/")) {
        int start = header.indexOf("filename=")+"filename=".length()+1;
        int end = header.indexOf("\r\n")-1;
        String filename = header.substring(start, end);
        System.out.println(filename);
        FileOutputStream fos = new FileOutputStream(filename);
        multipartStream.readBodyData(fos);
    } else {
        multipartStream.readBodyData(System.out);
    }
    System.out.println("");
    nextPart = multipartStream.readBoundary();
}