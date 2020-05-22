import processing.net.*; 
Client myClient; 

String uuid = "F326597E";
String name = "Name";

void setup() { 
  size(300, 300);

  if(args.length < 2) System.err.println("uuid,name args missing, using defaults: " + uuid+","+name+"\n");
  else{
    uuid = args[0];
    name = args[1];
    println("parsed args uuid: " + uuid+"\tname:" + name);
  }

  // Connect to the local machine at port 10002.
  // This example will not run if you haven't
  // previously started a server on this port.
  myClient = new Client(this, "127.0.0.1", 6789); 
  // Say hello
  myClient.write("UUID="+uuid+"&NAME="+name);
  exit();
} 

void draw() {
}