response.setContentType("application/force-download");
response.setContentLength((int)f.length());
        //response.setContentLength(-1);
response.setHeader("Content-Transfer-Encoding", "binary");
response.setHeader("Content-Disposition","attachment; filename=\"" + "xxx\"");//fileName);
...
...
File f= new File(fileName);

InputStream in = new FileInputStream(f);
BufferedInputStream bin = new BufferedInputStream(in);
DataInputStream din = new DataInputStream(bin);

while(din.available() > 0){
    out.print(din.readLine());
    out.print("\n");
}