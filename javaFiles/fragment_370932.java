@SuppressWarnings("unchecked")
private void loadBundle(String bundleFileName, Map<String, String> map)
                                                         throws IOException {
    InputStream in = BundleBean.class.getResourceAsStream(bundleFileName);
    try {
        Properties props = new Properties();
        props.load(in);
        ((Map) map).putAll(props);
    } finally {
        in.close();
    }
}