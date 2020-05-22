public Boolean readFile (){ //Fix tomorrow
    while( input.hasNext () ) {
       char x =           input.next().charAt(0); // get the char
       System.out.println("char obtained: "+x);

       String line =      input.nextLine().trim();
       Scanner stat =     new Scanner(line).useDelimiter("\\s*:\\s*")

       while ( stat.hasNext() ) {
          if (stat.hasNext("")||stat.hasNext(Pattern.compile("/.*"))) continue;
          // above line is equivalent to:
          // if( token.length()== 0 || token.charAt(0) == '/' ) continue;
          // but is better because does not consume a token
          switch ( x ) {
              case 'c' :
                  int a =         stat.nextInt(); // 20002
                  String b =      stat.next(); // "The Dragon"
                  System.out.println("b obtained: "+b);
                  // some options here:
                  // - add a line for each expected var like:
                  String b2 =      stat.next(); // "Dreama"
                  String i =      stat.nextInt(); // 10000
                  String j =      stat.nextInt(); // 1
                  // ...

                  // OR: - iterate through the remaining tokens and do something
                  // while (stat.hasNext()) { System.out.println(stat.next()); }

                  // OR: - get an array of the remaining tokens using split():
                  // String[] restOfLine = stat.nextLine().split("\\s*:\\s*");
                  break;
              case 't' :
                  //...