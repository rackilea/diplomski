Scanner sc = new Scanner(System.in);
Pattern delimiters = Pattern.compile(System.getProperty("line.separator")+"|\\s");
sc.useDelimiter(delimiters); 
while (sc.hasNextInt()){
    int i = sc.nextInt();
    //... do stuff with i ...
    System.out.println("Scanned: "+i);
}