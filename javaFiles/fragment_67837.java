public static Map<String, List<Path>> readPathsFromFile(Scanner inFile) {
  Map<String, List<Path>> adj_list =  new TreeMap<String, List<Path>>();

  // You do not need a list here
  // ArrayList<Path> list1 = new ArrayList<Path>();

  while (inFile.hasNext()){ // TO- DO add parts for both ways.
    String input = inFile.nextLine();
    String[] token = input.split(",");

    // 1.) Take care of 0 -> 1
    // Try and fetch the list from your treemap saved under 0
    List<Path> token0List = adj_list.get(token[0]);

    // If there was no list previously saved, you have a null value now
    if(token0List == null){

        // since there was no list previously saved,
        // create a new (empty) one and save it in the tree
        token0List = new ArrayList<Path>();
        adj_list.put(token[0], token0List );

    }

    // At this point of time, you can be sure that the token0List
    // exists and is saved correctly in the tree.

    // now you only need to add the 0 -> 1 path to the list
    // and you are done with this part of the saving.
     Path path = new Path(token[1],Double.parseDouble(token[2]));    
    token0List .add(path); // finish 0 -> 1


    // 2.) Take care of 1 -> 0
    // same procedure as 0 -> 1, only that you are swapping 
    // token[0] and token[1]
    List<Path> token1List = adj_list.get(token[1]);
    if(token1List == null){
        token1List = new ArrayList<Path>();
        adj_list.put(token[1], token1List );

    }
     Path path2 = new Path(token[0],Double.parseDouble(token[2]));    
    token1List .add(path2); // finish 1 -> 0



  }

  return adj_list;
}