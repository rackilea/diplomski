public int compareTo(Player that)
{
  int result;

  result = this.family.compareTo(that.family); 
  if (result != 0)                              // is the family name different?
  {
    return result;                              // yes ... use it to discriminate
  }

  result = this.given.compareTo(that.given);
  if (result != 0)                              // is the given name different?
  {
    return result;                              // yes ... use it to discriminate
  }

  result = this.age - that.age;                 // is the age different?
  if (result != 0)
  {
    return result;                              // yes ... use it to discriminate
  }

  ... (and so on) ...
  ... with the final one ...

  return this.dismisses - that.dismisses;       // only thing left to discriminate by
}