private String[] getAvailableJavaVersions() {
    List<String> userJavaVersions = new ArrayList<String>();

    for(String javaVersion: Arrays.asList("1.6", "1.7", "1.8")) {
        if(MaxJProject.getJavaClassPath("JavaSE-" + javaVersion) != null) {
            userJavaVersions.add(javaVersion);
        }
    }

    return userJavaVersions.toArray(new String[userJavaVersions.size()]);
}