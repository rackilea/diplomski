while((text=sb.readLine())!=null)//counting words
  {
      vowels = 0;
      numberofwords = 0;
      StringTokenizer words = new StringTokenizer(text);
      numberofwords=numberofwords+words.countTokens();

      for (i=0;i<text.length();i++)
      {
          ch=text.charAt(i);
          if (ch=='a'||ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U')
          {
              vowels++;
          }

      }
      System.out.print(text);
      System.out.print("          "+numberofwords);
      System.out.println("                        "+vowels);

  }