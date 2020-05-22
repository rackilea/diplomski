private static int readdata()throws FileNotFoundException {
        Scanner input=new Scanner(new File("setsofdata.txt"));
        int countSets=0;
        String line="";
        while(input.hasNextLine()){
             line=input.nextLine();
            countSets++;
        }
        System.out.println("Sets of data read are "+countSets);
        return countSets;

    }
    public static void main(String[]args)throws FileNotFoundException{
        readdata();
    }