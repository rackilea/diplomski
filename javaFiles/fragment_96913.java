BufferedReader reader = null;
try {
    reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsInputStream("/resources/MasterResourceList.txt")));
    String name = null;
    while ((name = br.readLine()) != null) {
        URL url = getClass().getResource(name);
    }
} finally {
    try {
        br.close();
    } catch (Exception exp) {
    }
}