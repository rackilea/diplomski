StringBuffer sb = new StringBuffer( 1024 );
        BufferedReader reader = new BufferedReader( new FileReader( fullPathFilename ) );

        while( true ) {
            String line = reader.readLine();
            if(line == null) {
                break;
            }
            sb.append( line );
        }
        reader.close();