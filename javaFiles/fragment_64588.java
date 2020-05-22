Calendar today = Calendar.getInstance();
Calendar expireDate = Calendar.getInstance();

expireDate.set(2011, Calendar.AUGUST, 12);

if (today.compareTo(expireDate) == 0 || today.compareTo(expireDate) == 1)

{
// expired - please purchase app

}
else
{
// do some stuff
}