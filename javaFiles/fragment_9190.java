Path topDir = Paths.get(RECURSIVE_DIRECTORY);
    Files.walk(topDir)
        .filter(path -> path.getFileName().toString().endsWith(".7z"))
        .forEach(path -> {
            try {
                JThreadTar.decompressSevenz(path.toString(), topDir.toFile());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
    });