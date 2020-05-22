DateTimeComparator dateTimeComparator = DateTimeComparator.getDateOnlyInstance();

Date myDateOne = ...;
Date myDateTwo = ...;

int retVal = dateTimeComparator.compare(myDateOne, myDateTwo);

if(retVal == 0)
   //both dates are equal
else if(retVal < 0)
   //myDateOne is before myDateTwo
else if(retVal > 0)
   //myDateOne is after myDateTwo