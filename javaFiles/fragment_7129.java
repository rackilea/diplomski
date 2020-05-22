List<String> lst = new LinkedList<>();
  int indx =0;
  int count =0;
  Scanner in = new Scanner(new File(filename));
       while (in.hasNextLine()){
          String str = in.nextLine();
          lst.add(str);
            if (str.indexOf("architecture") !=-1){
            indx=count;// get the index.
          }
        count++;
       }