public boolean setAge(int ageP) {
    // if our age param is negative, set age to 0
    if (ageP < 0) 
        this.age = 0
    else 
        this.age = ageP;
    // return true if value was good (greater than 1) 
    // and false if the value was bad
    return ageP >= 0;
}