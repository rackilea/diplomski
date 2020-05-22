String jcsConfFile = System.getProperty("XXXXXX");

if (jcsConfFile == null || jcsConfFile.trim().length() == 0) {
  log.error("error:JCSManager .........");
} else {
  Properties props = new Properties();

  try {
    // load a properties file
    props.load(new FileInputStream(jcsConfFile));
  } catch (IOException e) {
    log.error("error:JCSManager ........", e);
  }

  CompositeCacheManager ccm = CompositeCacheManager.getUnconfiguredInstance();

  ccm.configure(props);
}

//....
// later, ask for the region
JCS cache = JCS.getInstance(region);