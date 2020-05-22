JarFile jar = new JarFile(YourJarFile);
                ZipEntry e = jar.getEntry(CLASS_FILE_TO_FIND);
                if (e == null) {
                    e = jar.getJarEntry(CLASS_FILE_TO_FIND);
                    if (e != null) {
                        foundIn.add(f.getPath());
                    }
                } else {
                    foundIn.add(f.getPath());
                }