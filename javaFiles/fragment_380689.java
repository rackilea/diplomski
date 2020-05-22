List<Integer> p1 = new ArrayList<>();
List<Integer> p2 = new ArrayList<>();

for(int x: Player1) {
   p1.add(x);
}

for(int y: Player2) {
   p2.add(y);
}

for(int i=0;i<p1.size(); i++) {
    x = p1.get(i);
    y = p2.get(i);
    if (x < y) {
        System.out.println(" Player 1 wins the round: " + x + " beats " + y);
    } else if (x > y) {
        System.out.println(" Player 2 wins the round: " + y + " beats " + x);  
    } else {
        System.out.println("Tie!" + x + " ties with " + y);
    }
}