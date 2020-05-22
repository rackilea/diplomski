ArrayList<Integer> High = new ArrayList<Integer>();
ArrayList<Integer> Low = new ArrayList<Integer>();
while (!win){    //numbers is your array
    int x = scan.nextInt();
    if (game.guess(x))
        win = true;
    else if ( x > desired) //where desired is the random integer
       High.add(x);
    else 
       Low.add(x);
}
for (int x : High)
     System.out.println(x);
for (int x : Low)
     System.out.println(x);