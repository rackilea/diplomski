long t= System.currentTimeMillis();
long end = t+15000;
while(System.currentTimeMillis() < end) {
  // do something
  // pause to avoid churning
  Thread.sleep( xxx );
}