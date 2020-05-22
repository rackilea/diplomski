Octagon first;
boolean seenFirst = false;

while (fin.hasNext()) {
   double side = fin.nextDouble();
   if (side < 0.0) break;
   Octagon octagon = new Octagon(side);
   if (!seenFirst) {
       first = octagon;
       seenFirst = true;
   }
   // ... do stuff with octagons
}