String GL = getOwner().getGL("GLACCT"); 
String[] array=GL.split("-");
String segment1 = array[0]; 
String segment2 = array[1]; 

//check if array have 3rd element 
if(array.length >2)
      String segment3 = array[2];
else
       System.out.println("No third element") ;