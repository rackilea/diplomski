int numberTrue=0; //adjust this in your other code accordingly
Random r = new Random ();
int rand = r.nextInt (24);
// loop until not true found or stop if all items are true
while (array [rand] && numberTrue < 24) {
  rand = r.nextInt (24);
  count++;
}