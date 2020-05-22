File file = new File("C:\\Users\\lucas\\Desktop\\file-with-800MB.log");

    LineIterator it = FileUtils.lineIterator(file, "UTF-8");
    try {           
        while (it.hasNext()) {
            String line = it.nextLine();
            // do something with line, here just sysout...
            System.out.println( line );
        }
    } finally {
        LineIterator.closeQuietly(it);
    }