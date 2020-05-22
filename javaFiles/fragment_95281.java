int t = 4; // bypassing the Scanner here
// initialize outer list with initial capacity 5
List<List<Integer>> recipe = new ArrayList<List<Integer>>(t+1);
for(int i=1 ; i<t+1 ; i++){
    // initializes inner list
    recipe.add(new ArrayList<Integer>());
    // careful, you're using a different control variable to access the list elements
    for (int l = 1; l <= 4; l++) {     
        // collections are 0-indexed, hence l - 1
        recipe.get(l - 1).add(i);  
    }
}