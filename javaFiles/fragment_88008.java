public boolean equals(Object obj)
 {
   if (obj == null)
     return false;
   if (!(obj instanceof Name))
     return false;
   Name name = (Name) obj;
   return this.name.equals(name.name);
 }

 public int hashCode()
 {
   return name.hashCode();
 }