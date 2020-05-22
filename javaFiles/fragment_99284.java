System.out.println("Enter the number of trials:");
int trials = scnr.nextInt();

int sum = 0;

for (int i=1;i<=trials;i++) {
  System.out.print("Trial #" + i + ": ");
  int count = 0;  
  int diceAdded = 0;
  while (diceAdded != 7) {
    int dice = r.nextInt(6)+1;
    int dice2 = r.nextInt(6)+1;
    diceAdded = dice + dice2;
    count++;
  }
  System.out.println(count + " rolls to roll a 7.");
  sum += count;
}