FileInputStream fis = new FileInputStream("data/maps/ssdebug1.cfg");
Properties prop = new Properties();
prop.load(fis);
fis.close();

// you can have any number of properties with comments. 
// However, it is not assumed aline ends with a ';'
String start_x = prop.getProperty("start-x");
double startx = Double.parseDouble(start_x);