public <S> Iterable<S> load(Class<S> ifc) throws Exception {
  ClassLoader ldr = Thread.currentThread().getContextClassLoader();
  Enumeration<URL> e = ldr.getResources("META-INF/services/" + ifc.getName());
  Collection<S> services = new ArrayList<S>();
  while (e.hasMoreElements()) {
    URL url = e.nextElement();
    InputStream is = url.openStream();
    try {
      BufferedReader r = new BufferedReader(new InputStreamReader(is, "UTF-8"));
      while (true) {
        String line = r.readLine();
        if (line == null)
          break;
        int comment = line.indexOf('#');
        if (comment >= 0)
          line = line.substring(0, comment);
        String name = line.trim();
        if (name.length() == 0)
          continue;
        Class<?> clz = Class.forName(name, true, ldr);
        Class<? extends S> impl = clz.asSubclass(ifc);
        Constructor<? extends S> ctor = impl.getConstructor();
        S svc = ctor.newInstance();
        services.add(svc);
      }
    }
    finally {
      is.close();
    }
  }
  return services;
}