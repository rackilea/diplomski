public boolean equals(Object obj) {
   if (obj == null) { return false; }
   if (obj == this) { return true; }
   if (obj.getClass() != getClass()) {
     return false;
   }
   MyClass rhs = (MyClass) obj;
   return new EqualsBuilder()
                 .appendSuper(super.equals(obj))
                 .append(field1, rhs.field1)
                 .append(field2, rhs.field2)
                 .append(field3, rhs.field3)
                 .isEquals();
  }