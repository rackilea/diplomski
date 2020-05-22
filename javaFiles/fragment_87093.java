int result = 0;
try (Stream<String> stream = Files.lines(Paths.get(txt.getAbsolutePath()))) {
      //either print the lines or take the count.
      //stream.forEach(System.out::println); 
      result = (int)stream.count(); 
} catch (IOException e) {
      e.printStackTrace();
}