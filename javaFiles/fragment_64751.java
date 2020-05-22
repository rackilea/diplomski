String target = "temp_";

    String fullPath = "C:/Dump/sol1/temp_results/temp_2012-04-core.pcap";

    StringBuffer sb = new StringBuffer(fullPath);
    int end = fullPath.lastIndexOf(target) + target.length();

    System.out.println(sb.replace(fullPath.lastIndexOf(target), end, ""));