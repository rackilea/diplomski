Scanner sc = new Scanner(System.in);
String x; // no need to init here String x = "";
int Distance = 0;
int Index1 = 0;
int Index2 = 0;
List<Integer> AllNum = new ArrayList<>();
do {
    System.out.println("Please enter a number");
    int NewNumber = sc.nextInt();
    AllNum.add(NewNumber);
    System.out.println("Do you want to enter a new number? Enter Y for yes and N for no");
    x = sc.next(); // here changed sc.nextLine() -> sc.next()
} while (x.equalsIgnoreCase("y")); // here changed equals() -> equalsIgnoreCase()

int Index = AllNum.size();
int[] AllNumArray = new int[Index];
for (int i = 0; i < Index; i++) {
    AllNumArray[i] = AllNum.get(i);
}
for (int i = 0; i < Index; i++) {
    // here changed, and the main problem was here,
    int nextIndex = i < AllNumArray.length - 1 ? i + 1 : 0;
    int NewDistance = AllNumArray[i] - AllNumArray[nextIndex];
    if (NewDistance > Distance) {
        Distance = NewDistance;
        Index1 = i;
        Index2 = i + 1;
    }
}
System.out.println("The smallest distance between two neighboring numbers is: " + Distance);
System.out.println("The first Nnumber is " + AllNumArray[Index1] + ", and its index is " + Index1);
System.out.println("The second Nnumber is " + AllNumArray[Index2] + ", and its index is " + Index2);