@Override
public boolean equals(Object obj)
{
  if (this == obj) {
    return true;
  }
  if (obj == null) {
    return false;
  }
  if (getClass() != obj.getClass()) {
    return false;
  }

  Player that = (Player) obj;
  return this.age == that.age &&
         this.height == that.height &&
         this.weight == that.weight &&
         this.games == that.games &&
         this.runs == that.runs &&
         this.dismisses == that.dismisses &&
         this.given.equals(that.given) &&
         this.family.equals(that.family);
}