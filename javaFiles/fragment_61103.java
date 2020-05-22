public void unjar(File jar, File outputPath) throws IOException {
    JarFile jarFile = null;
    try {
        if (outputPath.exits() || outputPathFile.mkdirs()) {
            jarFile = new JarFile(jar);
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                File path = new File(outputPath + File.separator + entry.getName());
                if (entry.isDirectory()) {
                    if (!path.exists() && !path.mkdirs()) {
                        throw new IOException("Failed to create output path " + path);
                    }
                } else {
                    System.out.println("Extracting " + path);

                    InputStream is = null;
                    OutputStream os = null;
                    try {
                        is = jarFile.getInputStream(entry);
                        os = new FileOutputStream(path);

                        byte[] byteBuffer = new byte[1024];
                        int bytesRead = -1;
                        while ((bytesRead = is.read(byteBuffer)) != -1) {
                            os.write(byteBuffer, 0, bytesRead);
                        }
                        os.flush();
                    } finally {
                        try {
                            os.close();
                        } catch (Exception e) {
                        }
                        try {
                            is.close();
                        } catch (Exception e) {
                        }
                    }
                }
            }
        } else {
            throw IOException("Output path does not exist/could not be created");
        }
    } finally {
        try {
            jarFile.close();
        } catch (Exception e) {
        }
    }
}

public void jar(File jar, File sourcePath) throws IOException {
    JarOutputStream jos = null;
    try {
        jos = new JarOutputStream(new FileOutputStream(jar));

        List<File> fileList = getFiles(sourcePath);
        System.out.println("Jaring " + fileList.size() + " files");

        List<String> lstPaths = new ArrayList<String>(25);
        for (File file : fileList) {
            String path = file.getParent().replace("\\", "/");
            String name = file.getName();

            path = path.substring(sourcePath.getPath().length());
            if (path.startsWith("/")) {
                path = path.substring(1);
            }

            if (path.length() > 0) {
                path += "/";
                if (!lstPaths.contains(path)) {
                    JarEntry entry = new JarEntry(path);
                    jos.putNextEntry(entry);
                    jos.closeEntry();
                    lstPaths.add(path);
                }
            }

            System.out.println("Adding " + path + name);

            JarEntry entry = new JarEntry(path + name);
            jos.putNextEntry(entry);

            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                byte[] byteBuffer = new byte[1024];
                int bytesRead = -1;
                while ((bytesRead = fis.read(byteBuffer)) != -1) {
                    jos.write(byteBuffer, 0, bytesRead);
                }
                jos.flush();
            } finally {
                try {
                    fis.close();
                } catch (Exception e) {
                }
            }
            jos.closeEntry();
        }
        jos.flush();
    } finally {
        try {
            jos.close();
        } catch (Exception e) {
        }
    }
}