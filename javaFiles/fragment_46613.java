List<Integer> maxList = new ArrayList<Integer>();
List<Integer> minList = new ArrayList<Integer>();

while(in.hasNextLine()){ //while there is a next line do
   line = in.nextLine(); //take line
   String content[] = line.split("\t"); // split by tabs
   //get the maxT and minT
   Integer maxT = Integer.valueOf(content[1]);
   Integer minT = Integer.valueOf(content[2]);
   //store for future use
   maxList.add(maxT); 
   minList.add(minT);
   }

//Do something on your 2 lists to find the average