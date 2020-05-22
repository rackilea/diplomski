Socket client;
while(true) {
try{
client = server.accept();
executor.execute(new Handler(client));
}