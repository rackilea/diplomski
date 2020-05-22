System.out.println("list the most recent file per direct subdirectory");
// find all direct directories below /tmp/foobar
Files.find(root, 1, (path, attrs) -> attrs.isDirectory())
        // filter out the root itself
        .filter(p -> !p.equals(root))
        .forEach((dir) -> {
            try {
                // find all contained files in any subdirectory
                Optional<Path> recentFile = Files.find(dir, Integer.MAX_VALUE, 
                            (path, attrs) -> attrs.isRegularFile())
                        // return the file with the recent last
                        // modification time
                        .max((p1, p2)
                                -> Long.compare(p1.toFile().lastModified(),
                                   p2.toFile().lastModified()));
                // if a file was found
                if (recentFile.isPresent()) {
                    // print modification time and file name
                    printFileInfo(recentFile.get().toFile());
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
            }
        });