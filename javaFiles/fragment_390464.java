enum Coins { PENNY(1), POUND(100), NOTE(500); 

  // snip 
  public String toString() {
    return Utils.toEnumString(this);
  }
}