//Overriding equals
 public boolean equals(Object obj) 
  {
    if (this == obj) return true;
    if (obj == null) return false;
    if (this.getClass() != obj.getClass()) return false;
    Student that = (Student) obj;
    if (!this.name.equals(that.name)) return false;
    if (!this.ssn.equals(that.ssn)) return false;
    if (!this.gpa.equals(that.gpa)) return false;
    return true;
  }
}