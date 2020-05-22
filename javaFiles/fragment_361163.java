public boolean equals(Object o) {
   if (o== null) return false;
   if (!(o instanceof MyClass)) return false;
   MyClass other = (MyClass) o;
   if (other.firstString != null && this.firstString != null 
    && this.firstString.equals(other.firstString) return true;
   return false;
}