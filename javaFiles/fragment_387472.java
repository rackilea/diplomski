try{
          FileOutputStream file = new FileOutputStream("filename.txt", true);
          PrintStream out = new PrintStream(file);

                        String s=line;
                        String[] items = s.split("\t");

                            for(String item : items){
                                if(item.length()<8){            //here
                                    out.print(item + "\t\t" );  //here
                                }else{
                                    if(item.length()>16){       //here
                                    out.print(item + "\t" );
                                    }
                                }

              }catch (IOException e){
                  System.out.println("Error: " + e);
                  System.exit(1);
              }

            }