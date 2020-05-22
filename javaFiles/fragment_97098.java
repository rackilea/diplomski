BufferedReader br = new BufferedReader(System.in); 
System.out.println("storey: ");     
int storey = Integer.parseInt(br.readLine()); 

System.out.println("width: ");     
int width = Integer.parseInt(br.readLine()); 

System.out.println("length: "); 
int length = Integer.parseInt(br.readLine()); 

Property p = new Property(storey, width, length); 
System.out.println("property dimensions:width " + p.calculateArea()); 
System.out.println("width: " + p.getWidth()); 
System.out.println("length: " + p.getLength()); 
System.out.println("storeys: " + p.getStoreys()); 
System.out.println("area: " + p.calculateArea());
System.out.println("price: " + p.calculatePrice());