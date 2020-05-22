Octagon first = null;

while (fin.hasNext()) {
   double side = fin.nextDouble();
   if (side < 0.0) break;
   Octagon octagon = new Octagon(side);
   if (first == null) {
       first = octagon;
   }
   // ... do stuff with octagons
}