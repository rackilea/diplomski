if ((this.Username.compareToIgnoreCase(object.Username) < 0) || (this.Password.compareTo(object.Password) < 0))
{
  result = -1;
}
else if ((this.Username.compareToIgnoreCase(object.Username) < 0) && (this.Password.compareTo(object.Password) < 0))
{
    result = 0;
}