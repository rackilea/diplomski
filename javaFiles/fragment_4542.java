if ((this.getHour() >= this.getOSStartHour()) && 
        (this.getHour() < this.getSecurityStartHour())) 
{ 
    string = "We're in OS class."; 
}
else if ((this.getHour() >= this.getSecurityStartHour()) && 
        (this.getHour() < this.getForensicsStartHour()))
{ 
    string = "We're in Security class."; 
}
else 
{
    string = "We have no class.";
}