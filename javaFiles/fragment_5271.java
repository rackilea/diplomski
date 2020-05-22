CookieStore store = ((CookieManager) CookieHandler.getDefault()).getCookieStore();
try {
  Files.write(Values.COOKIESFILE.toPath(), ("").getBytes(), StandardOpenOption.TRUNCATE_EXISTING);

  for (URI uri : store.getURIs()) {
    Map<String, List<String>> map = CookieHandler.getDefault().get(uri, new HashMap<>());

    Files.write(Values.COOKIESFILE.toPath(), (uri + "|Cookie:").getBytes(), StandardOpenOption.APPEND);

    for (HttpCookie cookie : store.get(uri)) {
      if (cookie.hasExpired())
        continue;

      Files.write(Values.COOKIESFILE.toPath(), (CookieUtil.toString(cookie) + "~").getBytes(), StandardOpenOption.APPEND);
    }

    Files.write(Values.COOKIESFILE.toPath(), "\n".getBytes(), StandardOpenOption.APPEND);
  }
} catch (IOException e) {
  e.printStackTrace();
}