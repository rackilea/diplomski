public void init() {
   ...
   AccessController.doPrivileged(new PrivilegedAction() {
      public Object run() {
         writeFile();
         return null;
      }
   });
   ...
}