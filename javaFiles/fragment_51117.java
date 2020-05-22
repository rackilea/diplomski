// using getResourceAsStream
InputStream is = this.getClass().getResourceAsStream( "picture.gif" );
// or
InputStream is = MyClass.class.getResourceAsStream( "stuff.ser" );
// or
InputStream is = MyApp.class.getClassLoader().getResourceAsStream( "InWords.properties" );