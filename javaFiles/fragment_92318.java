public int[][] readFile(String fileName) throws FileNotFoundException, IOException {
   String line = "";
   ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();


   FileReader fr = new FileReader(fileName);
   BufferedReader br = new BufferedReader(fr);

   int r = 0, c = 0;//Read the file
   while((line = br.readLine()) != null) {
       Scanner scanner = new Scanner(line);
       list.add(new ArrayList<Integer>());
       while(scanner.hasNext()){

           list.get(r).add(scanner.nextInt());
           c++;
       }
       r++;
   }

   //Convert the list into an int[][]
   int[][] data = new int[list.size()][];
   for (int i=0;i<list.size();i++){
       data[i] = new int[list.get(i).size()];
      for(int j=0;j<list.get(i).size();j++){
          data[i][j] =  (list.get(i).get(j));
      }


   }
   return data;
}