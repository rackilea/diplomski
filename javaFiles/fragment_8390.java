public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);  
    Log.d("Input : ");

    StringBuilder test = new StringBuilder();

    String input = "";
    long measure = 0;
    while(input != null){
        input = scan.findInLine("."); // Should consume input one char per one char.

        measure++;
        if(input != null)
            test.append(input.charAt(0));

        if(measure == 1 || measure % 1000 == 0) // displays the reading time of first reads and the next thousand ones
            Log.d("Reading at:"+measure);

    }
    Log.d("End");
    scan.close();

    Log.d("size: "+test.toString().length());
    }
}