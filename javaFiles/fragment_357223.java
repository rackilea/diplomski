int compareTo(Object obj){
Term term = (Term)obj;
if(term.getElement < this.getElement())
  return 1;
else if (term.getElement == this.getElement())
  return 0;
else
  return -1;
}