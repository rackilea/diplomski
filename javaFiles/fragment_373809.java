File editableQueryMap = new File("./QueryMap.json");

    if (!editableQueryMap.exists()) {
      File defaultQueryMap = new ClassPathResource("QueryMap.json").getFile();

      try (OutputStream os = Files.newOutputStream(editableQueryMap.toPath())) {
        Files.copy(defaultQueryMap.toPath(), os);
      }
    }

    //do your changes with editableQueryMap here