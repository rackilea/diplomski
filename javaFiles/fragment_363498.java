String[] ipList = { "127.0.0.1" };
System.out.println(Arrays.toString(ipList));
int len = ipList.length;
ipList = Arrays.copyOf(ipList, len + 1);
ipList[len] = "192.168.2.1";
System.out.println(Arrays.toString(ipList));