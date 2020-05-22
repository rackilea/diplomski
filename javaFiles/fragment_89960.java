public boolean equals (Object other) {
    if(other == this) return true;

    if(other instanceof Person == false) return false;


    if(this.getName().equals(((Person) other).getName())) return true;

}