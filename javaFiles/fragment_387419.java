private void updateAge(){
    Period age = Period.between(this.getDateOfBirth(), today);
    this.years = age.getYears();
}  
public void setYearsAge(long years) {
     updateAge();
}
public long getYearsAge() {
  if(this.years ==0 )
{
      updateAge();
}
    return this.years;
}