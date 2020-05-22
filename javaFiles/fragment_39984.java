public static void main(String[] args) throws IOException {
    //Read text file
    FileReader fr = new FileReader("primary1.txt");
    BufferedReader br = new BufferedReader(fr);

    //2D array
    String[][] primary = new String[44][5];

    //Section break 
    System.out.println("1. The file contents are:\n");

    //Add column titles
    System.out.println("States\t\t\t\tCandidate#1\tVotes\t\tCandidate#2\tVotes");

    //Set delimiter as "/"
    String line; 
    int i=0;
    while((line=br.readLine())!=null){
        primary[i]=line.split("/");
        i++;
    }

    //Print text file
    for(int row=0; row<primary.length; row++){
        for(int col=0; col<primary[row].length; col++){
            //Add space between columns
            System.out.print(primary[row][col] + "\t\t");
        }
        //Newline
        System.out.println();
    }        

    //Clinton's delegates in order from highest to lowest
    for(int row=0; row<primary.length-1; row++){            
        for(int row1=row+1; row1<primary.length; row1++) {
            //Parse Integer
            int delC = Integer.parseInt(primary[row][2]);
            int delC1 = Integer.parseInt(primary[row1][2]);
            if(delC < delC1){
                String[]tmpprimary = primary[row];
                primary[row] = primary[row1];
                primary[row1] = tmpprimary;               
            }
        }                
    }
    System.out.println("\n**************************** Order Descending *******************************");
    System.out.println("States\t\t\t\tCandidate#1\tVotes\t\tCandidate#2\tVotes");
    for(int row=0; row<primary.length; row++){
        for(int col=0; col<primary[row].length; col++){
            //Add space between columns
            System.out.print(primary[row][col] + "\t\t");
        }
        //Newline
        System.out.println();
    } 
}