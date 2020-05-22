while((s=br.readLine())!=null)
{
    strtok=new StringTokenizer(s," ");
    while(strtok.hasMoreTokens())
    {
        bw.write("\n"+strtok.nextToken());
    }
    //br.close(); <----- move this to outside the while loop
}
br.close();