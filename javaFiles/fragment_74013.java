public Properties loadPropertiesFromInformixRetainedJarsTable(final String propertyFileName) {
    final Connection conn = ...;
    final Statement stmt = conn.createStatement();
    final ResultSet rs = stmt.executeQuery("SELECT jarname, jardata FROM retained_jars");

    if (rs.next()) {
        final JarInputStream jar = new JarInputStream(rs.getBinaryStream("jardata"));

        JarEntry jarEntry;
        while ((jarEntry = jar.getNextJarEntry()) != null) {
            if (jarEntry.getName().equals(propertyFileName)) {
                // read JAR entry content
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                final byte[] buf = new byte[2048];
                int readCnt;

                // reading from JarInputStream reads from current JarEntry
                while ((readCnt = jar.read(buf, 0, 2048)) != -1) {
                    baos.write(buf, 0, readCnt);
                }

                final Properties properties = new Properties();
                // load properties from byte array through StringReader
                properties.load(new StringReader(new String(baos.toByteArray())));

                return properties;
            }
        }
    }

    // here should be of course some usual cleaning of resources (like connection, input stream ...)

}