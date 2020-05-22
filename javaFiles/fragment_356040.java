public boolean createFolder(String folderName) throws MessagingException   
{   
    store = session.getStore("imap");   
    System.out.println("connecting store..");   
    store.connect("imap.gmail.com", 993, "something@gmail.com", "password");   
    System.out.println("connected !");   
    Folder defaultFolder = store.getDefaultFolder();   
    return createFolder(defaultFolder, folderName);   
}   

/*  
 * Note that in Gmail folder hierarchy is not maintained.  
 * */  
private boolean createFolder(Folder parent, String folderName)   
{   
    boolean isCreated = true;   

    try  
    {   
        Folder newFolder = parent.getFolder(folderName);   
        isCreated = newFolder.create(Folder.HOLDS_MESSAGES);   
        System.out.println("created: " + isCreated);   

    } catch (Exception e)   
    {   
        System.out.println("Error creating folder: " + e.getMessage());   
        e.printStackTrace();   
        isCreated = false;   
    }   
    return isCreated;   
}