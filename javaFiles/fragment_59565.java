zipStream = new ZipInputStream(channelSftp.get("Port_Increment_201405261400_2251.zip"));
 zipStream.getNextEntry();

 sc = new Scanner(zipStream);
 while (sc.hasNextLine()) {
     System.out.println(sc.nextLine());
 }