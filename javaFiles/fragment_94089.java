private URL determinePersistenceUnitRootLocation() {
        Class<?> source = getClass();
        try {
            URL url = source.getProtectionDomain().getCodeSource().getLocation();
            return ResourceUtils.extractJarFileURL(url);
        }
        catch (Exception ex) {
            logger.info("Could not determine persistence " + "unit root location from "
                    + source + " : " + ex);
        }
        return null;
    }