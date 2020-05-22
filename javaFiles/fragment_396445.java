Properties props = new Properties();
FileInputStream fis = new FileInputStream( "database.properties" );
props.load( fis );
fis.close();

props.setProperty("jdbc.url", {{urlvalue}} );
props.setProperty("jdbc.user", {{user value}} );
props.setProperty("jdbc.pass", {{pass value}} );

FileOutputStream fos = new FileOutputStream( "database.properties" );
props.store( fos );
fos.close();