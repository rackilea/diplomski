Random rand = new Random(); 
LinkedList<Koord> ownArea = new LinkedList<Koord>();
Koord point1 = new Koord(rand.nextInt(99), rand.nextInt(99));
Koord point2 = new Koord(rand.nextInt(99), rand.nextInt(99));

ownArea.add(point1);
ownArea.add(point2);

for(Koord c : ownArea) {
    System.out.println("x: " + c.getX() + " y: " + c.getY());
}