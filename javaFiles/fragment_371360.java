// do reading, usually  loop until end of file reading  
String mLine =  reader.readLine();// reading each line.

while (mLine != null) {
    //process line

    if. (mLine.matches(theirpass)) { // when an. account is found stop reading
         System.out.println("cheking mLine"+ mLine);
        checking  = theirpass; //trying to set vale of. checking to theirpass
          Log.d("if statement in mline",checking);
         mLine=null;// trying to stop the loop

    }//end if

    mLine =   reader.readLine();
}// end loop