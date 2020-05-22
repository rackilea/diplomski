public int hashCode() {
   HashCodeBuilder hb = new HashCodeBuilder();
   hb.append(field1);
   hb.append(field2);
   ...
   return hb.toHashCode();
}