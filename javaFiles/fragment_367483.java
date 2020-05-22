/**
 * It loads the 'config.properties' file into a FileInputStream object.
 *
 * @return The FileInputStream object.
 */
private FileInputStream loadInputPropertiesFile() {
    FileInputStream input = null;

    // Let's load the properties file from the *.jar file parent folder...
    File jarPath = new File(PropertiesManagement.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    String propertiesPath = String.format("%s" + File.separator, jarPath.getParentFile().getAbsolutePath());
    propertiesPath = propertiesPath.replace("%20", "\u0020");

    try {   
        // ... and setting the pointer to the same path, ready to read the properties file.
        input = new FileInputStream(propertiesPath + CONFIG_FILE_PATH);
    } catch (FileNotFoundException e) {
        System.out.println("Properties file not found! Have you deleted it?");
        e.printStackTrace();
    }

    return input;
}