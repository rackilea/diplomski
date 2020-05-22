try {
      InputStream in = Crawler.class.getClassLoader()
              .getResourceAsStream("twitter4j.properties");
      prop.load(in);
  } catch (IOException e) {
      log.error(e.toString());
  }