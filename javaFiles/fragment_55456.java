for(int t=0; t<superArray.size(); t++) {

     // ....etc....
     String line=temp+","+temp2+","+temp3+","+temp4+","+temp5 + eol;

     File myFoo = new File("Letters.csv");
     FileWriter fooWriter = new FileWriter(myFoo, true); 


     fooWriter.write(line);
     fooWriter.close();
}