public String getClasspathString() {
     StringBuffer classpath = new StringBuffer();
     ClassLoader applicationClassLoader = this.getClass().getClassLoader();
     if (applicationClassLoader == null) {
         applicationClassLoader = ClassLoader.getSystemClassLoader();
     }
     URL[] urls = ((URLClassLoader)applicationClassLoader).getURLs();
      for(int i=0; i < urls.length; i++) {
          classpath.append(urls[i].getFile()).append("\r\n");
      }    

      return classpath.toString();
  }