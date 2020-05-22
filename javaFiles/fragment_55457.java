// file created *before* the for loop
File myFoo = new File("Letters.csv");
FileWriter fooWriter = new FileWriter(myFoo, true); 

for(int t=0; t<superArray.size(); t++) {

     // .... etc ....
     String line=temp+","+temp2+","+temp3+","+temp4+","+temp5 + eol;
     fooWriter.write(line); // line written inside for loop

}

// this should be in the finally block.
fooWriter.close();