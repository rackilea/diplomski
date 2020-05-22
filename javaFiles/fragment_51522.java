task createJar(type: Jar) {
    from {
        List<File> allFiles = new ArrayList<>();
        configurations.compile.collect {
            for (File f : zipTree(it).getFiles()) {
                if (f.getName().equals("classes.jar")) {
                    allFiles.addAll(zipTree(f).getAt("asFileTrees").get(0).getDir())
                }
            }
        }
        allFiles.add(new File('build/intermediates/classes/release'))
        allFiles // To return the result inside a lambda
    }
    archiveName('MySDK.jar')
}