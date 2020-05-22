boolean isSet = false;
     List<String> duplicates = new ArrayList<String>();
     if((isSet = set.add(text))){
      //this will get printed for only unique values added
         System.out.println(text+"is unique");
       }
      else{
        if(!duplicates.contains(text)){
        duplicates.add(text);
        System.out.println(text+"is first duplicate");
        }
      }