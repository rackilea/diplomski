public static void main( String[] args ) {

        Path source = Paths.get( "C:\\Downloads\\fileinput\\fileinput.csv" );
        Path destination = Paths.get( "C:\\Downloads\\landingzone\\fileinput.csv" );

        try {

            if ( Files.exists( destination ) ) { // check file is exists at destination

                System.out.println( "File exists already." );
            } else {

                Files.copy( source, destination );

                System.out.println( "File copied successfully" );
            }


        } catch ( IOException e ) {

            System.out.println( "File move unsuccessful!" );
            e.printStackTrace();
        }
    }