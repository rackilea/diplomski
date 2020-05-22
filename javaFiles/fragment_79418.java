public String getHashtags()
 {
      if(hashtags == null)
      {
           return null;
      }

      String returnString = "Hashtags:";
      int count = 0;

      while(count < hashtags.length)
      {
           //hashtags is an array of String objects with an unknown size

           returnString = returnString + "\n\t\t"+hashtags[count];
           count++;
      }

      return returnString;

 }