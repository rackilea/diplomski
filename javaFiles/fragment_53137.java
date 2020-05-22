try(FileSystem fs = zipProvider.newFileSystem(this.directory, immutableMap)) {
    Path zipRoot = fs.getPath("/");
    CopyOption[] option = {
        StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES
    };
    Files.walk(this.world).forEach(sourcePath -> {
        try {
            Path destination = zipRoot;
            for(Path p: this.world.relativize(sourcePath))
                destination = destination.resolve(p.toString());
            if(!Files.isDirectory(destination) || !Files.isDirectory(sourcePath))
                Files.copy(sourcePath, destination, option);
        } catch(IOException e) {
            throw new UncheckedIOException(e);
        }
    });
} catch(IOException|UncheckedIOException e) {
    e.printStackTrace(); // TODO replace with actual exception handling
}