//......
   int left = line.indexOf("{");
   int right = line.indexOf("}");

    if(left > 0 && right > 0){
      String subMyString = line.substring(left+1, right);  
      for (String myWord : subMyString.split("\\W+")) {    
      if (myWord.length() > 0)        
          context.write(new Text(myWord), new IntWritable(1));       
      }
     }
   //..........