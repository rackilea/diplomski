System.out.printf("java version \"%s\"%n" +
                  "%s (build %s)%n" +
                  "%s (build %s, %s)%n",
                  System.getProperty("java.version"),
                  System.getProperty("java.runtime.name"),
                  System.getProperty("java.runtime.version"),
                  System.getProperty("java.vm.name"),
                  System.getProperty("java.vm.version"),
                  System.getProperty("java.vm.info"));