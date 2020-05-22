Stream<String> lineStream = Files.lines(Paths.get("your_file"));

    lineStream.forEachOrdered((s) -> {
        if ("HEADER".equals(s)) {
            // create new file
        }
        else {
            // append to this file
        }
    });