String className = args[0];
Class clazz = Class.forName( className );
Method main = clazz.getMethod( "main", new Class[] { String[].class } );

List/*<String>*/lines = new ArrayList/*<String>*/();
Reader in = new InputStreamReader( new FileInputStream( args[1] ), "UTF-8" );
try {
    lines = IOUtils.readLines( in );
} finally {
    in.close();
}

main.invoke( null, new Object[] { lines.toArray( new String[lines.size()] ) } );