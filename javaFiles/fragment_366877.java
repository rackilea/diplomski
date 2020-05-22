for(String s : mathML.split("\\s+(?=<math)|(?<=</math>)\\s+")){

   if (s.startsWith("<math")) {
    CTOMath ctOMath = getOMML(s);
    System.out.println(s);

    CTP ctp = paragraph.getCTP();
    ctp.addNewOMath();
    ctp.setOMathArray(ctp.sizeOfOMathArray()-1, ctOMath);        
   }
   else {
    run = paragraph.createRun();
    run.setText(s + " ");
    System.out.println(s);
   }
  }