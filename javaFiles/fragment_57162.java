if(attachmentsResp!=null)
{
    for(int j=0; j<attachmentsResp.length; j++)
    {
        if(attachmentsResp[j].getContent()!=null)
        {
            //getting the file to particular Driver Name(C drive ,D drive)
            OutputStream out = new FileOutputStream("Driver Name:"+attachmentsResp[j].getName()+"."+attachmentsResp[j].getFileType());
        }         
    }
}