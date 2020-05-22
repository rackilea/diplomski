public static String checkUserInputSeriesName(Scanner sc, SeriesLibrary seriesLibrary){
    boolean validInput = false;
    String seriesName = null;
    do{
        validInput = false;
        seriesName=sc.nextLine();
        for(int i = 0; i < seriesLibrary.getTvSeries().size(); i++){
            if(seriesName.equals(seriesLibrary.getTvSeries().get(i))){
                validInput = true;
            }
        }  
        if(!validInput){
            System.out.println("That Series does not exist, please try again!");
            sc.nextLine();
        } 
    }while(!validInput);
    return seriesName;
}