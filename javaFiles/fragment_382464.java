File f = new File("root.properties");
FileInputStream fis = new FileInputStream(f);

Properties p = new Properties();
p.load(fis);
fis.close();

p.setProperty("root.label.43.2", "Updated");