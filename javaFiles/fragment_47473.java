private void logClassPath(final Class clazz) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    ClassLoader cl = clazz.getClassLoader();
    pw.println("Processing classloader which loaded " + clazz.getName() +" classloader: "+cl.getClass().getName());
    if (cl instanceof URLClassLoader) {
      logUrls(pw, (URLClassLoader) cl);
    } else {
      pw.println("Unsupported classloader - " + cl.getClass().getName());
    }
    while (cl.getParent() != null) {
      cl = cl.getParent();
      pw.println("\n\nProcessing parent classloader" +" classloader: "+cl.getClass().getName());
      if (cl instanceof URLClassLoader) {
        logUrls(pw, (URLClassLoader) cl);
      } else {
        pw.println("Unsupported classloader - " + cl.getClass().getName());
      }
    }
    pw.flush();
    System.out.print(sw.toString());

  }

  private void logUrls(final PrintWriter pw, final URLClassLoader cl) {
    if( cl.getURLs().length == 0 ) {
      pw.println("No URLs registered for this classloader");
    }
    for (URL url : cl.getURLs()) {
      pw.println(url.toString());
    }
  }