public Passport(String name,int number, Date expiryDate)
{
  this.name=name;
  this.number=number;
  Date copyExpiryDate = new Date(this.expiryDate);  
  this.expiryDate = copyExpiryDate;
}