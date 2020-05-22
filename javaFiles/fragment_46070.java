while((str=br.readLine())!=null)
 {
     if(!Character.isUpperCase(str.charAt(0)))
     {
           wordList.add(str);
     }
     number++;
 }