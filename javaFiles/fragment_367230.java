HashMap<String,Integer[]> things = new HashMap<String,Integer[]>();

// Read each line and add to HashMap using:
Name = productName;
nums[0] = inFile.nextInt();
nums[1] = inFile.nextInt();
things.put(Name,nums);

// When you're done, ask the user what they're looking for and look it up.
productComp = console.next();
Integer[] nums = things.get(productComp);
if(nums == null){ // or try/catch for NullPointerException
   // Doesn't exist! Try again!
}else{
      productAmount = nums[0];
      productPrice = nums[1];
      sum += calculateSum(productAmount, productPrice, productComp);
      check = true;
}