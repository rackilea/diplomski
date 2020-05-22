//first create an array of locations to your jar files
jarArray = ["#libDirectory#/CFEvernote.jar","#libDirectory#/evernote-api-1.18.jar","#libDirectory#/libthrift.jar"];

//then create an instance of the classloader and pass it your jar array
classLoader = createObject("component", "JavaLoader").init(jarArray );

//then use the classloader.create method to create a new java object
note = classLoader.create("com.evernote.edam.type.Note").init();