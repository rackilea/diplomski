@ProcessElement
    public void processElement(ProcessContext c) { 
      // assuming "c.element()" is a line in your CSV         
      String[] strArr = c.element().split(",");  // this contains your CSV columns
      int strArrlen = strArr.length;  // this is the number of columns

      // no need to iterate over each column you are concerned with column 3
      /** 
      * for (int i = 0 ;i < strArrlen ;i++)
      * {
      *   strsplit = strArr[i].split("|");
      * }
      */
      // get the values of the 4 column (events)
      String[] strsplit = strArr[3].split("\\|"); // 3 not 4 because is zero based

      if (strsplit.length == 0) {  // there are no events
         ClassEvent1 clr = new ClassEvent1();
         clr.setEvntType(strArr[0]);
         clr.setEvntKey(strArr[1]);
         clr.setEvntName(strArr[2]);
         clr.setEvntComponents(strArr[3]); // no events just put original value
         clr.setCustEvntStrt(strArr[4]);
         clr.setCustEvntEnd(strArr[5]);
         clr.setNotes(strArr[6]);
         c.output(clr);
      } else {

        // create class event for each event in column 3
        for (int i=0; i < strsplit.length; i++) {
          ClassEvent1 clr = new ClassEvent1();
          clr.setEvntType(strArr[0]);
          clr.setEvntKey(strArr[1]);
          clr.setEvntName(strArr[2]);
          clr.setEvntComponents(strsplit[i]); // increment for each event
          clr.setCustEvntStrt(strArr[4]);
          clr.setCustEvntEnd(strArr[5]);
          clr.setNotes(strArr[6]);
          c.output(clr);
        }
    }
}