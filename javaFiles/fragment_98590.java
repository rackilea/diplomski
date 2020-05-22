public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    //String LON = in.next();
    //String LAT = in.next();        
    String str = in.nextLine(); // use nextLine which you can read whole 
                                //line and store the data into a String
    in.nextLine();
    String[] infoDefib = DEFIB.split(";");//now you store them into a String array