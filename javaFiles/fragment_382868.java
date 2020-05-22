public static void TowersOfHanoiThree(int numDisk)
{
  //adding disk to stack
  temp = numDisk;
  tower = new Stack[4];

  for(int a = 0; a <= 3; a++)
  {
     tower[a] = new Stack<Integer>();
  }

 for (int i = numDisk; i > 0; i--)
 {
    tower[1].push(i); // to show "1 2 3" i changed the value which was pushed in the stack
// from tower[1].push(numDisk) to tower[1].push(i)
 }
 show(); //In your example this method call was placed inside the for loop.
//Moving it outside will show the stacks only after the values are added
 solver(numDisk, 1, 3, 2);
}

 public static void show() {
    // System.out.println("Pillar1: ");
    // System.out.println("Pillar2: ");
    // System.out.println("Pillar3: ");

    String Pillar1 = "Pillar1: ";
    String Pillar2 = "Pillar2: ";
    String Pillar3 = "Pillar3: ";

    String emptStr1 = "";
    String emptStr2 = "";
    String emptStr3 = "";
//the empStr variable are moved outside the loop because only after the 
//loop has finished we know what values are in each pillar
    for (int x = 0; x <= temp - 1; x++) {

        try {
//here we just append the values from the pillar to string empStr1
            emptStr1 += String.valueOf(tower[1].get(x)) + " ";
        } catch (Exception e) {
        }

        try {
            emptStr2 += String.valueOf(tower[2].get(x)) + " ";
        } catch (Exception e) {
        }

        try {
            emptStr3 += String.valueOf(tower[3].get(x)) + " ";
        } catch (Exception e) {
        }
    }
//finally when the loop is done we have the results
    System.out.print(Pillar1 + emptStr1 + "\n");
    System.out.print(Pillar2 + emptStr2 + "\n");
    System.out.print(Pillar3 + emptStr3 + "\n");
    System.out.print("\n");
}// end show