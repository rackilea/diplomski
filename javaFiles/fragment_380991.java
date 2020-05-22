Scanner scan = new Scanner(new File("random.txt"));
  String name = "" ;
  while (scan.hasNextLine()){
    name  = scan.nextLine();
   if (name.contains("legal")){
  System.out.println(name);
  }
}




  scan.close();