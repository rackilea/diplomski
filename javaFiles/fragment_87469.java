MyClass m = new MyClass();

Date dateToBeSet = new Date();
m.setBillDate(dateToBeSet); //The actual dateToBeSet is set to m

dateToBeSet.setYear(...); 
//^^^^^^^^ Un-intentional modification to dateToBeSet, will also modify the m's billDate