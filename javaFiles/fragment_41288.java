String cipher_stream = new String("2057216345135157862323621293695559030383785129357667531585938249534612483932237388388135819035165204");
  StringBuffer resultbuff=new StringBuffer("");
  for(int pl = 0;pl<cipher_stream.length();pl++)
  {
            //append space as per given condition...
            if (pl!= 0 && (pl % 5 == 2 || pl % 5 == 0))
                resultbuff.append(' ');
               resultbuff.append(cipher_stream.charAt(pl));


  }
  System.out.println(resultbuff);