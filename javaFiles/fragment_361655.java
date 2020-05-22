List<Integer> calories = new ArrayList<Integer>();  

Scanner myfile = new Scanner(new FileReader("ARRAYLAB1.txt")); 

while (myfile.hasNext()) {     
    calories.add(myfile.nextInt());   // Read file content using a while loop
} 

List<Integer> breakfast = new ArrayList<Integer>();
List<Integer> lunch = new ArrayList<Integer>();
List<Integer> dinner = new ArrayList<Integer>();

//the rest just assigns each value to their respective array 
int counter = 1;
for (int i = 0; i < calories.size(i); i++) {
    if (counter == 1) {
        breakfast.add(calories.get(i)); 
        counter++;
        continue;
    }
    if (counter == 2) {
        lunch.add(calories.get(i)); 
        counter++;
        continue;
    }
    if (counter == 3) {
        dinner.add(calories.get(i)); 
        counter = 1; 
        continue;
    }
}