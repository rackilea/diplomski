DirectoryStream<Path> stream = ...;
List<Path> list = new ArrayList<>();
stream.forEach(list::add);
list.sort(Comparator.comparing(Path::toString));
for (Path entry: list) {
  System.out.println("reading: " +entry);
}