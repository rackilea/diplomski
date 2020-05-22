while(( length = inputstream.read(buffer)) > -1)
               {
            down += length;
                    bufferedoutputstream.write(buffer, 0 , length);
            String text = clientDL.label1.getText();
             int perc = getPerc();

     if(perc <= 50)        
    {
    text +=  getPerc() + "% done";
    }else
    {
     text ="Please wait until the jar is downloading..."
     text = text + (100 - perc) + " % remaining"
    } 
       }