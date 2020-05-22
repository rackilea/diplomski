try(DirectoryStream<Path> ds
                     =Files.newDirectoryStream(Paths.get("/sys/block"), "sd*")) {
  StreamSupport.stream(ds.spliterator(), false)
    .map(p->p.resolve("device/model")).map(wrap(Files::readAllBytes))
    .map(String::new).forEach(System.out::println);
}