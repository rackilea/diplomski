class CustomClassLoader extends ClassLoader {

         public Class findClass(String name) {
             if(shouldBeLoaded)
                return defineClass(name, b, 0, b.length);
         }
    }