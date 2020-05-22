Planet[] vals = Planet.values();
for(int i=0; i<vals.length; i++) {
    Planet p = vals[i];
    System.out.printf("Your weight on %s is %f%n",
              p, p.surfaceWeight(mass));
}