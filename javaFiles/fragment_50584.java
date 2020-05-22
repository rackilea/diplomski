myObj = new String("I am awesome!");
myObj.toString(); //OK, it calls Object.toString
//myObj.substring(5, 12); //** COMPILE ERROR, there is no Object.substring
((String)myObj).substring(5, 12); //OK, it calls String.substring

myObj = new Mess();
//myObj.cleanItUp(); //** COMPILE ERROR, there is no Object.cleanItUp
((Mess)myObj).cleanItUp(); //OK, it calls Mess.cleanItUp
((String)myObj).substring(5, 12); //** RUNTIME ERROR, myObj is not a String