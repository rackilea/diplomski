final String input = "I'm a test string to drop 'c' but not 'cc', 'ccc', 'cccc', ok ?";

String result = input
                    .replaceAll( "c([^c])", "$1" )
                    .replaceAll( "c([^c])", "cc$1" );

// result will be "I'm a test string to drop '' but not 'cc', 'ccc', 'cccc', ok ?"