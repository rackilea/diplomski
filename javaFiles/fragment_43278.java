FileInputStream fis = null;
try {
    fis = new FileInputStream(file);
} catch (FileNotFoundException e) {
    BufferedWriter writer = new BufferedWriter(new FileWriter(configFile));
    writer.write(defaultConfig);
    writer.close();
    fis = new FileInputStream(file);
}

try{
     builder = builderFactory.newDocumentBuilder();
     document = builder.parse (fis);