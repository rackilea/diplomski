FileReader fr=new FileReader("path of the html file");
BufferedReader br= new BufferedReader(fr);
StringBuilder content=new StringBuilder(1024);
while((s=br.readLine())!=null)
    {
    content.append(s);
    }