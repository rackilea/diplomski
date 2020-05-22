Integer yearGiven="1997"
String year =driver.findElement(By.cssSelector(".ui-datepicker-year"))).getText();

String intYear =Integer.parseInt(year); // get Current year

if(intYear>yearGiven){
// Click left arrow
}

else if (intYear<yearGiven){
// Click right arrow
}
 /* You can also convert Integer to String */ 
Integer x=1955;
String strYear = String.valueOf(x);
// compare code goes here