new Reflections(
    /* 
     * ConfigurationBuilder is used to build a configuration parsable by Reflection.
     * This configuration must include a few things :
     * - where to look for classes
     * - what to look in classes
     */
      new ConfigurationBuilder()
        /*
         * FilterBuilder answers the *where* question by specifying which fragments 
         * of classpath are to be scanned. Indeed, as far as I understand, 
         * Reflections can parse the whole classpath, which will be way to slow 
         * for anybody  (and contains lots of useless java.* classes). So your 
         FilterBuilder defines include patterns for the packages you need
         */
          .filterInputsBy(new FilterBuilder().include("your project's common package prefix here..."))
          .setUrls(ClasspathHelper.forClassLoader())
          /*
           * Scanner defines the what : if you look for subclasses, you'll need 
           * to add a subclass scanner. if you look for 
           * annotations, the type annotation scanner is required, and so on.
           */
          .setScanners(new SubTypesScanner(), new TypeAnnotationsScanner().filterResultsBy(myClassAnnotationsFilter)));