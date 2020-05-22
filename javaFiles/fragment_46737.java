component {
    this.name = "YourAppName";
    // loads individual jars 
    this.javaSettings = { LoadPaths = [ "C:\path\to\pdfbox-2.0.16.jar"
                                        , "C:\path\to\xmpbox-2.0.16.jar"
                                        , .. more paths
                                      ]
                        };
}