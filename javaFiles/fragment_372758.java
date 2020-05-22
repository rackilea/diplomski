public List<String> loadFiles() throws IOException, Exception {
        List<String> fileNames = new ArrayList<>();
        URL resourceUrl = getClass().getResource("/protocol");
        VirtualJarInputStream jarInputStream = (VirtualJarInputStream) resourceUrl.openStream();
        JarEntry jarEntry = null;
        while ((next = jarInputStream.getNextJarEntry()) != null) {
            fileNames.add(jarEntry.getName());
        }
        return fileNames;
    }