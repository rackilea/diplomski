static {
        javaVersion = System.getProperty("java.version");
        // version String should look like "1.4.2_10"
        if (javaVersion.indexOf("1.7.") != -1) {
            majorJavaVersion = JAVA_17;
        }
        else if (javaVersion.indexOf("1.6.") != -1) {
            majorJavaVersion = JAVA_16;
        }
        else if (javaVersion.indexOf("1.5.") != -1) {
            majorJavaVersion = JAVA_15;
        }
        else {
            // else leave 1.4 as default (it's either 1.4 or unknown)
            majorJavaVersion = JAVA_14;
        }
    }