@Override
public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + this.age;
  result = prime * result + this.dismisses;
  result = prime * result + this.family.hashCode());
  result = prime * result + this.games;
  result = prime * result + this.given.hashCode());
  result = prime * result + this.height;
  result = prime * result + this.runs;
  result = prime * result + this.weight;
  return result;
}