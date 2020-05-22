public static void main(String[] args) {
    System.out.println("hello");
    try {
        Process p = Runtime.getRuntime().exec("./prog.sh");
        InputStream in = p.getInputStream();

        System.out.println("OUTPUT");
        StringBuilder sb = new StringBuilder();
        int c;
        while( (c = in.read() ) > 0 ) {
            sb.append((char) c);
        }

        //here the script finished
        String output = sb.toString();
        if( output.contains("Exception")) { 
            System.out.println("script failed");
        }

        if( p.exitValue() == 0) {
            System.out.println("The script run without errors");
        } else {
            System.out.println("The script failed");
        }
    } catch (IOException e) {
        e.printStackTrace(); 
    }
}