public void loadWidgets() {

    boolean ide = true;
    String path = "textFiles/widgets/";        
    ArrayList<String> results = new ArrayList<>();
    String dir = new File("").getAbsolutePath() + "/src/Creator/" + path;

    try {
        getWidgetFiles(dir, results);

        results.stream().forEach((s) -> {
            readFile(s);
        });

        updateWidgetVariables();
    } catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
        ide = false;
    }


    if (!ide) {
        CodeSource src = WidgetPanel.class.getProtectionDomain().getCodeSource();
        try {                
            List<String> list = new ArrayList<>();
            if (src != null) {
                URL jar = src.getLocation();
                ZipInputStream zip = new ZipInputStream(jar.openStream());
                ZipEntry ze = null;                    

                while ((ze = zip.getNextEntry()) != null) {

                    String entryName = ze.getName();                        
                    if (entryName.startsWith("Creator/textFiles/widgets") && entryName.endsWith(".txt")) {
                        // Wouldnt work until i added the "/" before the entryName
                        list.add("/"+ entryName);
                        System.out.println("Added name: " + entryName);
                    }
                }
                list.stream().forEach((s) -> {
                    readJarFile(s);
                });

                updateWidgetVariables();

            } else {
                System.out.println("Src null");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}