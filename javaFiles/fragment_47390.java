InputStream in = MyClass
                .class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .openStream();