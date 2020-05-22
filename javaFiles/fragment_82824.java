@Override
public int compareTo(Person o) {
   if (this.age != o.age) {
      return this.age < o.age ? -1 : 1;
   }
   return this.name.compareTo(o.name);
}