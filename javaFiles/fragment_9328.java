//given that 'input' got the contents of the file

Map<String,String> m = new HashMap<String,String>();

//this can be done more efficient probably but anyway
//normalize all types of line breaks to '\n'
input = input.replaceAll("\r\n","\n");
input = input.replaceAll("\r","\n");


//populate map
String[] lines = input.split("\n");
for(int i=0 ; i< lines.length; i++){
  String[] nv = lines[i].split("=");
  m.put(nv[0],nv[1]);
}

//get value given key: 
String key = "somekey";
String someValue = m.get(key);
System.out.println(someValue);