Function<Path,byte[]> uncheckedRead = p -> {
  try { return Files.readAllBytes(p); }
  catch(IOException ex) { throw new UncheckedIOException(ex); }
};
try(Stream<Path> s=Files.find(Paths.get("/sys/block"), 1,
    (p,a)->p.getName(p.getNameCount()-1).toString().startsWith("sd"))) {
  s.map(p->p.resolve("device/model")).map(uncheckedRead).map(String::new)
   .forEach(System.out::println);
}