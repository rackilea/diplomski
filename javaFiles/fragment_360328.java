StreamConnection s = null;

try {
s = (StreamConnection) Connector.open(searchContactUrl);
//your code
} catch (SecurityException se) {
   this.notifyDestroyed();
}