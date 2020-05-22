@Bean
    File filesystemRoot() {
      try {
        return new File("/path/to/your/images/outside/webapp");
      } catch (IOException ioe) {}
      return null;
    }

    @Bean
    FileSystemResourceLoader fileSystemResourceLoader() {
      return new 
         FileSystemResourceLoader(filesystemRoot().getAbsolutePath());
    }