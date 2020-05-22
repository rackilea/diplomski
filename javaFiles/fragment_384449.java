public void action() {

 openFile();                     // grab file with Scanner
 extractDataIntoArray();         // extract values from text value and put in array

 openFile();                     // grab file with Scanner...
 extractDataIntoArray2();        // extract values from text file and put in array2

 for(int i = 0; i < array.size() ;i++)
 {
    long l = Long.parseLong(array.get(i)); 

    string e2 = array2.get(i);
    event = createSpecificEvent(e2, l);
    addEvent(event);

    if(e2.equals("Terminate"))
     {
       break;
     }
 }
}