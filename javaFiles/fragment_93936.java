Thing t = new Thing(...);
if(t.needsAuth())
{
  boolean ok = t.doPassword("abc123");
  if(!ok)
    log("wrong password");
}
boolean did= t.doIt();
if(!did)
  log("sorry: " + t.getProblem());