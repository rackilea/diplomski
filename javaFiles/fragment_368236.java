public static void main(String[] args)throws IOException {
                if(args.length <1)
                {
                    System.out.println("wrong number of arguments");
                    System.exit(1);
                }
                for(int i=0; i<args.length; i++)
                {
                   BufferedReader file = new BufferedReader(new FileReader(args[i]));
                   int NumberofRows =0, NumberofCharacter =0;
                   while(row = file.readLine()) !=null)
                   {
                      String row = file.readLine();
                      NumberofRows++;
                      NumberofCharacter = NumberofCharacter + row.length();
                    }
                }
                System.out.println("The files "+" data.txt " + " and " "data2.txt "+ "contains "+ NumberofRows+ "rows and  NumberofCharacter  contains"+
        NumberofCharacter +" character");
               file.close();
            }
    }