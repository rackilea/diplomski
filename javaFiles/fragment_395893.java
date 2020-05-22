try (Stream<String> lines = Files.lines(targetFile)) {
   List<String> replaced = lines
       .map(line-> line.replaceAll(plainTextPattern, replaceWith))
       .collect(Collectors.toList());
   Files.write(targetFile, replaced);
}