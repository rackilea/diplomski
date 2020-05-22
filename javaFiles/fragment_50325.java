input = new Scanner(file);

for (int rows = 0; rows < numbers.length; rows++){
   for (int columns = 0; columns < numbers[rows].length; columns++){
      numbers[rows][columns] = input.nextDouble(); 
   }
}