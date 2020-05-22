File fileName = new File("myfile.txt");         
                      Scanner inFile = new Scanner(fileName);
                       int sum=0;        
                      while (inFile.hasNext())         
                      {         
                           sum+= inFile.nextInt( );     
                      } 
                      System.out.println(sum);

                    inFile.close();