String text = "org.apache.felix.dm;version=\"[4.1,5)\",org.osgi.framework;version=\"[1.5,2)\",org.osgi.service.cm;version=\"[1.3,2)\",org.osgi.service.deploymentadmin;version=\"[1.0,2)\",org.osgi.service.deploymentadmin.spi;version=\"[1.0,2)\",org.osgi.service.event;version=\"[1.2,2)\",org.osgi.service.log;version=\"[1.3,2)\",org.osgi.service.metatype;version=\"[1.3,2)\",org.osgi.util.tracker;version=\"[1.4,2)\"";
    String[] strArray = text.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");  
    ArrayList<MyObject> list = new ArrayList<>();
    for (String string : strArray) {
        String currentPair[] = string.split(";");
        list.add(new MyObject(currentPair[0], currentPair[1]
                .replaceAll("\"", "")
                .replaceAll("version=", "")
                .replaceAll("\\[", "")
                .replaceAll("\\)", "").split(",")));
    }

    for (MyObject myObject : list) {
        System.out.print("Name: " + myObject.name + " - Versions:");
        for (String version : myObject.versions) {
            System.out.print(version + " ");
        }
        System.out.println();
    }