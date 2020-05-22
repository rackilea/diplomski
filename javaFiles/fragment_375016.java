File file = new File("yourfilename.txt");   
 String[] names = new String[50]; 
 int[] scores = new int[100]; 
 Scanner scanner = new Scanner(file);
 l = 0;

/*Core logic*/
 while (scanner.hasNextLine()) { 
 String line = scanner.nextLine();
 String [] words = line.split("\t"); 
 names[l] = words[0]; 
 scores[l] = Integer.parseInt(words[1]);
 System.out.println(" name: " + names[l] + ", score: " + scores[l]);
 l++; 
  }