for (String[][] parts : orders)
    for (String sep1 : sepFormats)
        for (String sep2 : sepFormats)
            for (String p1 : parts[0])
                for (String p2 : parts[1])
                    for (String p3 : parts[2])
                        System.out.println(p1 + sep1 + p2 + sep2 + p3);