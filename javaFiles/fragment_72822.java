try(DirectoryStream<Path> ds
                     =Files.newDirectoryStream(Paths.get("/sys/block"), "sd*")) {
  StreamSupport.stream(ds.spliterator(), false)
    .map(p->p.resolve("device/model")).flatMap(wrap(Files::lines))
    .forEach(System.out::println);
}