String[] arr;                       //create a string array to reference later
if (Input1.contains("=="))          //check string for measure
     arr = String.split("==");      //split string at those points
else if (Input1.contains("!="))     //a==2 -> ["a", "2"]
     arr = String.split("!=");
else if (Input1.contains(">"))
     arr = String.split(">");
else if (Input1.contains("<"))
     arr = String.split("<");