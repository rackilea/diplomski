public void findLines(String aFileName) {

     List<Integer> a = new ArrayList<Integer>();
     List<Integer> b = new ArrayList<Integer>();

    Pattern regexp = Pattern.compile("(if|else|while).*");
    Matcher exp1 = regexp.matcher("if|else|while");
    Path path = Paths.get(aFileName);
        try (
          BufferedReader reader = Files.newBufferedReader(path, ENCODING);
          LineNumberReader lineReader = new LineNumberReader(reader);
        ){
          String line = null;
          while ((line = lineReader.readLine()) != null) {
          exp1.reset(line); 


            if(exp1.find())
            {
                int l= lineReader.getLineNumber();


                b.add(l);

                     }

            else
            {int l= lineReader.getLineNumber();
                  a.add(l);


               }   

          } 


        System.out.println(a);
        System.out.println(b);
                }


       catch (IOException ex){
         ex.printStackTrace();
        }