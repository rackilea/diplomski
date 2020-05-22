myObj = new String("I am awesome!");
myObj.toString(); //OK, it calls Object.toString
//myObj.substring(5, 12); //** COMPILE ERROR, there is no Object.substring
String myString = (String)myObj;
myString.substring(5, 12); //OK, it calls String.substring

myObj = new Mess();
//myObj.cleanItUp(); //** COMPILE ERROR, there is no Object.cleanItUp
Mess myMess = (Mess)myObj;
myMess.cleanItUp(); //OK, it calls Mess.cleanItUp
myString = (String)myObj; //** RUNTIME ERROR, myObj is not a String