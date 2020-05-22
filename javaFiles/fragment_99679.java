try {
   // gets the "in" field
   Field f = Outer.class.getDeclaredField("in");
   // sets it accessible as it's private
   f.setAccessible(true);
   // gets an instance of the Inner class by getting the instance of the 
   // "in" field from an instance of the Outer class - we know "in" is
   // initialized in the no-args constructor
   Object o = Object o = f.get(Outer.class.newInstance());
   // gets the "execute" method
   Method m = o.getClass().getDeclaredMethod("test", (Class<?>[])null);
   // sets it accessible to this context
   m.setAccessible(true);
   // invokes the method
   m.invoke(o, (Object[])null);
}
// TODO better handling
catch (Throwable t) {
    t.printStackTrace();
}