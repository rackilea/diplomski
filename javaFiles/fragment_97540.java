final File myFile = (File) AccessController.doPrivileged(new PrivilegedAction() {
                public Object run(){
                    String fileName = System.getProperty("user.home") +
                      System.getProperty("file.separator") +
                      "pkcs11.conf";                    
                    return new File(fileName);
                }});