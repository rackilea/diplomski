HashMap<String, String> portsMap = new HashMap<>();

    File serialFolder = new File("/dev/serial/by-id");
    File[] listOfDevices = serialFolder.listFiles();

    for (int i = 0; i < listOfDevices.length; i++)
    {
        if (Files.isSymbolicLink(listOfDevices[i].toPath()))
        {
            try
            {
                String portName = listOfDevices[i].getName();
                String id = Files
                        .readSymbolicLink(listOfDevices[i].toPath())
                        .toString()
                        .substring(
                        Files.readSymbolicLink(listOfDevices[i].toPath())
                        .toString().lastIndexOf("/") + 1);
                portsMap.put(id, portName);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }