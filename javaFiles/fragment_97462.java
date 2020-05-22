Time      
 : Number ':' (Number (':' (Number (',' last=Number?)?)?)?)?
   {
     if($last.text == null) $type = Other;
   }
 ;