public static void main(String[] args) {
    String text = "org.apache.felix.dm;version=\"[4.1,5)\",org.osgi.framework;version=\"[1.5,2)\",org.osgi.service.cm;version=\"[1.3,2)\",org.osgi.service.deploymentadmin;version=\"[1.0,2)\",org.osgi.service.deploymentadmin.spi;version=\"[1.0,2)\",org.osgi.service.event;version=\"[1.2,2)\",org.osgi.service.log;version=\"[1.3,2)\",org.osgi.service.metatype;version=\"[1.3,2)\",org.osgi.util.tracker;version=\"[1.4,2)\"";
    String[] strArray = text.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
    ArrayList<MyObject> list = new ArrayList<>();
    for (String string : strArray) {
        String currentPair[] = string.split(";");
        list.add(new MyObject(currentPair[0], addDots(currentPair[1]
                .replaceAll("\"", "")
                .replaceAll("version=", "")
                .replaceAll("\\[", "")
                .replaceAll("\\)", "").split(","), 3)));
    }

    for (MyObject myObject : list) {
        System.out.print("Name: " + myObject.name + " - Versions:");
        for (String version : myObject.versions) {
            System.out.print(version + " ");
        }
        System.out.println();
    }
}

public static String[] addDots(String toAdd[], int dotcount) {
    String[] formattedVersions = new String[toAdd.length];
    for (int i = 0; i < toAdd.length; i++) {
        ArrayList<String> digits = new ArrayList<>();
        digits.add(toAdd[i]);
        if(toAdd[i].contains(".")) {
            digits = new ArrayList<>(Arrays.asList(toAdd[i].split("\\.")));
        }
        for(int x = digits.size(); x < dotcount; x++) {
            digits.add("0");
        }
        String curretnFormattedVersion = "";
        for (int j = 0; j < digits.size() - 1; j++) {
            curretnFormattedVersion += digits.get(j) + ".";
        }
        curretnFormattedVersion += digits.get(dotcount - 1);
        formattedVersions[i] = curretnFormattedVersion;
    }
    return formattedVersions;
}