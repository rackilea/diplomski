Path configFilePath = FileSystems.getDefault()
            .getPath("C:\\Users\\sharmaat\\Desktop\\issue\\stores");

    List<Path> fileWithName = Files.walk(configFilePath)
            .filter(s -> s.toString().endsWith(".java"))
            .map(Path::getFileName).sorted().collect(Collectors.toList());

    for (Path name : fileWithName) {
        // printing the name of file in every sub folder
        System.out.println(name);
    }