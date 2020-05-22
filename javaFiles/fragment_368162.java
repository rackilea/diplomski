private static List findEmAll()
    {
        List returnValue = new LinkedList();

        Set keySet = nameMap.keySet();
        for (String key : keySet)
        {
            List listaly = nameMap.get(key);
            String highValue = null;

            if (listaly.size() == 1)
            {
                highValue = listaly.get(0);
            }
            else
            {
                int highVersion = 0;

                for (String name : listaly)
                {
                    String[] versions = name.split("_V|\\.");

                    if (versions.length == 3)
                    {
                        int versionNumber = Integer.parseInt(versions[1]);
                        if (versionNumber > highVersion)
                        {
                            highValue = name;
                            highVersion = versionNumber;
                        }
                    }
                }
            }

            returnValue.add(highValue);
        }

        return returnValue;
    }