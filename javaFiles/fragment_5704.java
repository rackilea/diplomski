public class ForwardingGroup implements Group {
   final Group delegate;
   public ForwardingGroup(Group delegate) { this.delegate = delegate; }

   @Override public Point[] getCoordinates() {
       return delegate.getCoordinates();
   }
   @Override public boolean equals(Object o) {
       return ....; // insert your equals logic here!
   }
}