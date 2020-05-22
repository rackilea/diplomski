public int hashCode() {
     // you pick a hard-coded, randomly chosen, non-zero, odd number
     // ideally different for each class
     return new HashCodeBuilder(17, 37).
       append(name).
       append(age).
       toHashCode();
   }


public boolean equals(Object obj) {
   // do you basic object check first
   // then delegate to equalsbuilder
   MyClass rhs = (MyClass) obj;
   return new EqualsBuilder()
                 .append(name, rhs.name)
                 .append(age, rhs.age)
                 .isEquals();
  }