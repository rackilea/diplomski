// load the config file with fonts from remote resources (HTTP)
File configFileWithRemoteFontUrl = new File("fop-config.xconf");

// create a factory instance and disable the font cache
FopFactory factory = FopFactory.newInstance(configFileWithRemoteFontUrl);
factory.getFontManager().disableFontCache();

// your code as usual...