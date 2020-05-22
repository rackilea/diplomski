private List<String> getFiles() throws IOException {
    Resource[] resources = ResourcePatternUtils
            .getResourcePatternResolver(loader)
            // notice **
            .getResources("classpath*:elcordelaciutat/**");

    return Arrays.stream(resources)
               .filter(p -> p.getFilename().endsWith(".txt"))
               .map(p -> {
                   try {
                       String path = p.getURI().toString();
                       String partialPath = path.substring(
                           path.indexOf("elcordelaciutat"));
                       return partialPath;
                   } catch (IOException e) {
                            e.printStackTrace();
                   }

                   return "";
                })
               .sorted()
               .collect(toList());
}