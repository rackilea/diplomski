Octagon first;

if (fin.hasNext()) {
   double side = fin.nextDouble();
   if (side < 0.0) return; // return instead of break to exit from main()
   first = new Octagon(side);
   doStuffWithOctagons(first, first);
}

while (fin.hasNext()) {
   double side = fin.nextDouble();
   if (side < 0.0) break;
   Octagon octagon = new Octagon(side);
   doStuffWithOctagons(first, octagon);
}