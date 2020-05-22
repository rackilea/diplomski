Properties props1 = new Properties();
props1.load(new FileReader("p1.properties"));    
Properties props2 = new Properties();
props2.load(new FileReader("p2.properties"));

System.out.println(props1.equals(props2)); // true