File sdcard = Environment.getExternalStorageDirectory();
File file = new File(sdcard,"sample.txt");
InputStream is = new FileInputStream(file); // Read your existing file
Properties props = new Properties();
props.load(is);
props.setProperty("wpa_oper_channel", "4");
OutputStream out = new FileOutputStream(file); // Your output file stream
prop.store(output, null); // Save your properties file without header