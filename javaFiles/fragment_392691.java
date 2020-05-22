public static void writeRequestAndResponse(){

    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat( "yyyyMMddHHmmss" );

    String currentDateTime = format.format( date );

    String folderPath = "E:\\QA\\Output\\" + currentDateTime;

    File theDir = new File( folderPath );

    // if the directory does not exist, create it
    if (!theDir.exists()) {
        System.out.println( "creating directory: " + theDir.getName() );
        boolean result = false;

        try {

            theDir.mkdirs();
            result = true;
            final String folderpath1 = folderPath + "\\test.api\\" + "\\exceloutput";
            File theDir1 = new File( folderpath1 );
            theDir1.mkdirs();
            System.out.println( folderpath1 );

            String frompath = "E:\\Project\\src\\main\\java\\com\\qa\\testdata\\APITestData.xlsx";
            File file1 = new File( frompath );

            final String topath = folderpath1 + "\\outputFile.xlsx"; //The output file name included

            File file2 = new File( topath );
            Files.copy( file1.toPath(), file2.toPath() );
        } catch (Exception se) {
            // handle it
            System.out.println( se.getMessage() );
        }
        if (result) {
            System.out.println( "Folder created" );
        }
    } else if (theDir.exists()) {

        System.out.println( "Folder exist" );
    }

}