/**
 * Gets the app.version property value from
 * the ./main.properties file of the base folder
 *
 * @return app.version string
 * @throws IOException
 */

import java.util.Properties;

public static String getAppVersion() throws IOException{

    String versionString = null;

    //to load application's properties, we use this class
    Properties mainProperties = new Properties();

    FileInputStream file;

    //the base folder is ./, the root of the main.properties file  
    String path = "./main.properties";

    //load the file handle for main.properties
    file = new FileInputStream(path);

    //load all the properties from this file
    mainProperties.load(file);

    //we have loaded the properties, so close the file handle
    file.close();

    //retrieve the property we are intrested, the app.version
    versionString = mainProperties.getProperty("app.version");

    return versionString;
}