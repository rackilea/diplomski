//Must be declared outside of try block 
int index
try{
index = Integer.parseInt(numberID) - 1;
//Catches all NumberFormatExceptions but not other errors
} catch(NumberFormatException e) {
//Handle error here
}