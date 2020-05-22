public int compareTo(Object o) {
  Word w = (Word) o;
  if(this.count > w.getCount()){
    return -1;
  }
  else if (this.count < w.getCount()) {
    return 1;
  }
  else {
      return 0;
  }
}