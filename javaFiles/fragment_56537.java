try {
...
}catch(Exception e){
PrintWriter writer = new PrintWriter("trace.txt");
e.printStackTrace(writer);
writer.close();}