String path1 = "mydir1/";
String path2 = "mydir2/";
String file = request.getParameter("file");    
InputStreamReader isr;
BufferedReader br;
String line = "";
char id = request.getParameter("id").charAt(0);
if(id == '1') {
    isr = new InputStreamReader(new FileInputStream(mydir1 + file));
    br = new BufferedReader(isr);
    line = br.readLine();
    while(line!=null){
        out.println(line);
        line = br.readLine();
    }
}
else if(id == '2') {
    isr = new InputStreamReader(new FileInputStream(mydir2 + file));
    br = new BufferedReader(isr);
    line = br.readLine();
    while(line!=null){
        out.println(line);
        line = br.readLine();
    }
}
else {
    out.println("Error");
}