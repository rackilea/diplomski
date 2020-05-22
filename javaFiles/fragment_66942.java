for(Path f : files) {
    String targetPath = targetDir + System.getProperty("file.separator") + f.getFileName;
    File target = new File(targetPath);
    if(!target.exists())
        Files.copy(f, Paths.get(targetDir).resolve(f.getFileName()));
}