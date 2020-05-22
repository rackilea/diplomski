Iterator<YourClass> iter = dislist.iterator();
while (iter.hasNext()) {
     YourClass obj = iter.next();
     if (/* your expression */) {
          iter.remove();
     }
}