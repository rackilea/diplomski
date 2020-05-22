try (BufferedReader br = Files.newBufferedReader(Paths.get(file))) {
            this.bigMap = br.lines()
                            .collect(Collectors.groupingBy(s -> s.substring(0, 1)));
} catch (IOException e) {
     e.printStackTrace();
}