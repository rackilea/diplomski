String s = "cmd cd E:/My data/Final Project/Uji Coba bikin Jar & E: & jar cfm     
D:/EditingDiniApp.jar META-INF/MANIFEST.MF EditingDini META-INF net org";
FileOutputStream fos = new FileOutputStream("abc.bat");
fos.write(s.getBytes());
fos.close();
Thread.sleep(2000);
Runtime.getRuntime().exec("abc.bat");
Thread.sleep(2000);