int[][] nums = {{1,1,2},{3,4},{5},{6,7,8},{9,1,1}};

int foundCount = 0; 
for(int[] inner : nums){
    for(int i : inner){
        if (i == 1){
            foundCount++;
        }
    }
    System.out.println("Searched " + inner.length + 
                " elements, and found \'number one\' a total of " + foundCount + " times..");
}