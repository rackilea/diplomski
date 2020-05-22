String path = ClassLoader.class.getResource(directory).toExternalForm();
        if (path.startsWith("jar")) {
            try {
                URL url = new URL(path);
                System.out.println("JAR URL Name : " + url.toString());
                JarURLConnection connection = (JarURLConnection) url.openConnection();
                String jarFileName = connection.getJarFile().getName();
                System.out.println("JAR File Name : " + jarFileName);
                try (JarInputStream jarFile = new JarInputStream(new FileInputStream(jarFileName));) {
                    String regex = directory.substring(1);
                    do {
                        try {
                            JarEntry jarEntry = jarFile.getNextJarEntry();
                            if (jarEntry != null) {
                                String entryName = jarEntry.getName();
                                if (!regex.equals(entryName) && entryName.contains(regex)) {
                                    System.out.println("JAR Entry Name : " + entryName);
                                    try (InputStream in = YourClassName.class.getClassLoader().getResourceAsStream(entryName);
                                            Scanner scanner = new Scanner(in);) {
                                    //Do something in here                                       
                                    } catch (Exception ex) {
                                        System.out.println(ex);
                                    }
                                }
                            } else {
                                break;
                            }
                        } catch (IOException ex) {
                            System.out.println("JAR InputStream Error : " + jarFileName + " - > " + ex);
                            break;
                        }
                    } while (true);
                }
            } catch (Exception e) {
                System.out.println("JAR URL Connection Error : " + e);
            }
        } else {
            try {
                URL url = new URL(path);
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(url.openStream()))) {
                    String fileName;
                    while ((fileName = in.readLine()) != null) {
                        String filePath = directory + fileName;
                        try (InputStream is = ClassLoader.class.getResourceAsStream(filePath);
                                Scanner scanner = new Scanner(is);) {
                           //Do something here
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Classpath URL Connection Error : " + e);
            }
        }
    }