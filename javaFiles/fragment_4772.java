public boolean equals(Object o){
 if(o == null) { return false; }
 if(!(o instanceOf DateAD)) { return false; }
 DateAD date = (DateAD) o;

 return (this.year == date.year && this.dayOfYear == inputDate.dayOfYear);
}