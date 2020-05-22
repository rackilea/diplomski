String charData = "[318.0159, 331.81818, 324.71603, 348.4345, 323.108, 3.2360008]";
charData = charData.replace("[", "").replace("]", "");

String[] data = charData.split(",");
System.out.println(data[0]);
System.out.println(data[1]);
System.out.println(data[2]);
System.out.println(data[3]);
System.out.println(data[4]);
System.out.println(data[5]);