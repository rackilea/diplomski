CookieManager manager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);

try {
  for (String line : Files.readAllLines(Values.COOKIESFILE.toPath())) {
    String[] values = line.split("\\|");
    URI uri = new URI(values[0]);

    String[] actualValues = values[1].split(":");

    if (actualValues.length < 2)
      continue;

    for (String header : actualValues[1].split("~"))
      manager.getCookieStore().add(uri, CookieUtil.fromString(header));
    }
  } catch (IOException | URISyntaxException e) {
    e.printStackTrace();
  }

CookieHandler.setDefault(manager);