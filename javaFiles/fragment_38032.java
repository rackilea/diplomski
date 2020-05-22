while(files.hasMoreElements())
{
    String upload=(String)files.nextElement();

    File filename=new File(mrequest.getOriginalFileName(upload));

    filename.renameTo("newName");
}