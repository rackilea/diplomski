47     static {
   48         USE_NATIVE =
   49             AccessController.doPrivileged(new PrivilegedAction<Boolean>() {
   50                     public Boolean run() {
   51                             String osname = System.getProperty("os.name");
   52                             if (osname.startsWith("SunOS") ||
   53                                 osname.startsWith("Linux")) {
   54                                 return new Boolean(System.getProperty
   55                                     (USE_NATIVE_PROP));
   56                             }
   57                             return Boolean.FALSE;
   58                     }
   59             });
   60