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